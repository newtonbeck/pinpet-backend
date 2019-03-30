(ns api.user.conversion
  (:require [ring.util.response :as ring-response]))

(defn request->credentials [request]
  (let [email (get-in request [:body "email"])
        password (get-in request [:body "password"])]
    {:email email, :password password}))

(defn token->response [token]
  {:status 200
   :body token
   :headers {"Content-type" "text/plain"}})

(defn request->user [request]
  (let [name (get-in request [:body "name"])
        email (get-in request [:body "email"])
        password (get-in request [:body "password"])]
    {:name name, :email email, :password password}))
