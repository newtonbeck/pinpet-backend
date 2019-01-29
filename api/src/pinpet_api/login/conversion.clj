(ns pinpet-api.login.conversion
  (:require [ring.util.response :as ring-response]))

(defn request->credentials [request]
  (let [email (get-in request [:body "email"])
        password (get-in request [:body "password"])]
    {:email email, :password password}))

(defn token->response [token]
  (if token
    (ring-response/response {:token token})
    {:status 401}))
