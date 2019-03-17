(ns api.components.http-routes
  (:require [compojure.core :refer :all]
            [ring.util.response :as ring-response]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [api.user.controller :as user]
            [api.pet.controller :as pet]))

(defroutes routes-config
  (context "/api" []
    (POST "/login" request user/log-in)
    (POST "/register" request user/register)
    (GET "/pets" request pet/list-my-pets)
    (GET "/pets/locations" request pet/find-my-pets-locations))
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
