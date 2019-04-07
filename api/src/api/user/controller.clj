(ns api.user.controller
  (:require [api.security.jwt :as jwt]
            [api.security.password :as password]
            [api.user.database :as db]
            [api.user.conversion :as conversion]))

(defn log-in [request]
  (let [credentials (conversion/request->credentials request)
        user (db/find-user-by-email (:db request) (:email credentials))
        jwt-secret (get-in request [:config :jwt-secret])]
    (if (password/matches? user credentials)
      (->> user
        (jwt/create-token jwt-secret)
        conversion/token->response)
      {:status 401})))
            
(defn register [request]
  (->> request
    conversion/request->user
    password/encrypt
    (db/create-user! (:db request))
    (jwt/create-token (get-in request [:config :jwt-secret]))
    conversion/token->response))
