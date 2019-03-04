(ns api.log-in.controller
  (:require [api.log-in.database :as db]
            [api.log-in.conversion :as conversion]
            [api.log-in.security :as security]))

(defn log-in [request]
  (-> request
      conversion/request->credentials
      db/find-user-by-credentials
      security/user->token
      conversion/token->response))
