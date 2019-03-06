(ns api.register.controller
  (:require [api.register.conversion :as conversion]
            [api.register.database :as db]
            [api.log-in.conversion :as login-conversion]
            [api.log-in.security :as security]))

(defn register [request]
  (->> request
    conversion/request->user
    (db/create-user! (:db request))
    security/user->token
    login-conversion/token->response))
