(ns pinpet.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as ring-response]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [pinpet.login.database :as login-database]
            [pinpet.login.conversion :as login-conversion]
            [pinpet.login.security :as login-security]
            [pinpet.config :as config]))

(defroutes app-routes
  (POST "/api/login" request
    (-> request
      login-conversion/request->credentials
      login-database/find-user-by-credentials
      login-security/user->token
      login-conversion/token->response))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))
