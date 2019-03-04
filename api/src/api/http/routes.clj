(ns api.http.routes
  (:require [compojure.core :refer :all]
            [ring.util.response :as ring-response]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [api.login.controller :as login-controller]
            [api.location.conversion :as location-conversion]
            [api.location.controller :as location-controller]
            [api.config :as config]))

(defroutes routes-config
  (context "/api" []
    (POST "/login" request login-controller/log-in)
    (GET "/pets/locations" request
      (-> request
        location-conversion/request->user
        location-controller/find-pets-locations-by-user
        location-conversion/pets->response)))
  (context "/ops" []
    (GET "/health" []
      (ring-response/response {:health true}))))

(def api-routes
  (-> routes-config
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))
