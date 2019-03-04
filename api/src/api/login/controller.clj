(ns api.login.controller
  (:require [api.login.database :as db]
            [api.login.conversion :as conversion]
            [api.login.security :as security]))

(defn log-in [request]
  (-> request
      conversion/request->credentials
      db/find-user-by-credentials
      security/user->token
      conversion/token->response))
