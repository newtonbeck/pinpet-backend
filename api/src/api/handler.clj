(ns api.handler
  (:require [compojure.core :refer :all]
            [ring.util.response :as ring-response]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [api.login.conversion :as login-conversion]
            [api.login.controller :as login-controller]
            [api.location.conversion :as location-conversion]
            [api.location.controller :as location-controller]
            [api.config :as config]))

(defroutes app-routes
  (POST "/api/login" request
    (-> request
      login-conversion/request->credentials
      login-controller/log-in
      login-conversion/token->response))
  (GET "/api/pets/locations" request
    (-> request
      location-conversion/request->user
      location-controller/find-pets-locations-by-user
      location-conversion/pets->response))
  (GET "/api/health" []
    (ring-response/response {:health true})))

(def app
  (-> app-routes
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))
