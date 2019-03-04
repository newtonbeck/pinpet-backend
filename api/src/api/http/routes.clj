(ns api.http.routes
  (:require [compojure.core :refer :all]
            [ring.util.response :as ring-response]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [api.log-in.controller :as log-in-controller]
            [api.register.controller :as register-controller]
            [api.location.controller :as location-controller]))

(defroutes routes-config
  (context "/api" []
    (POST "/login" request log-in-controller/log-in)
    (POST "/register" request register-controller/register)
    (GET "/pets/locations" request location-controller/find-pet-locations))
  (context "/ops" []
    (GET "/health" []
      (ring-response/response {:health true}))))

(defn wrap-app-component [f db]
  (fn [request]
    (f (assoc request :db db))))

(defn make-handler [db]
  (-> routes-config
    (wrap-app-component db)
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))
