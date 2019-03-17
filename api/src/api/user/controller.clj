(ns api.user.controller
  (:require [api.user.database :as db]
            [api.user.conversion :as conversion]
            [api.user.security :as security]))

(defn log-in [request]
  (->> request
      conversion/request->credentials
      (db/find-user-by-credentials (:db request))
      security/user->token
      conversion/token->response))
            
(defn register [request]
  (->> request
    conversion/request->user
    (db/create-user! (:db request))
    security/user->token
    conversion/token->response))
