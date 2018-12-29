(ns pinpet.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as ring-response]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(def db [{:email "luke@rebels.org", :password "x-wing"}])

(defn request->credentials [request]
  (let [email (get-in request [:body "email"])
        password (get-in request [:body "password"])]
    {:email email, :password password}))

(defn find-user-by-credentials [credentials]
  (->> db
    (filter (partial = credentials))
    first))

(defn user->token [user]
  (:email user))

(defn token->response [token]
  (ring-response/response {:token token}))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (POST "/api/login" request
    (-> request
      request->credentials
      find-user-by-credentials
      user->token
      token->response))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))
