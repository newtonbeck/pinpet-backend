(ns api.user.controller
  (:require [api.security.jwt :as jwt]
            [api.user.database :as db]
            [api.user.conversion :as conversion]))

(defn log-in [request]
  (let [credentials (conversion/request->credentials request)
        user (db/find-user-by-credentials (:db request) credentials)
        jwt-secret (get-in request [:config :jwt-secret])]
    (if (empty? user)
      {:status 401}
      (->> user
        (jwt/create-token jwt-secret)
        conversion/token->response))))
            
(defn register [request]
  (->> request
    conversion/request->user
    (db/create-user! (:db request))
    (jwt/create-token (get-in request [:config :jwt-secret]))
    conversion/token->response))
