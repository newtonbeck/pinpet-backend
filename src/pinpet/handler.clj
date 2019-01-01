(ns pinpet.handler
  (:require [compojure.core :refer :all]
            [ring.util.response :as ring-response]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [pinpet.login.conversion :as login-conversion]
            [pinpet.login.controller :as login-controller]
            [pinpet.config :as config]))

(defroutes app-routes
  (POST "/api/login" request
    (-> request
      login-conversion/request->credentials
      login-controller/log-in
      login-conversion/token->response)))

(def app
  (-> app-routes
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))
