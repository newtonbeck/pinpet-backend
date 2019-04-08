(ns api.components.http-routes
  (:require [com.stuartsierra.component :as component]
            [ring.util.response :as ring-response]
            [compojure.core :refer :all]
            [api.user.controller :as user]
            [api.pet.controller :as pet]))

(defroutes routes-config
  (context "/api" []
    (POST "/login" request user/log-in)
    (POST "/register" request user/register)
    (GET "/pets" request pet/list-my-pets)
    (POST "/pets" request pet/create-pet)
    (GET "/pets/locations" request pet/find-my-pets-locations))
  (context "/ops" []
    (GET "/health" []
      (ring-response/response {:health true}))))

(defrecord HttpRoutesComponent []
  component/Lifecycle
  
  (start [this]
    (assoc this :http-routes routes-config))
    
  (stop [this]
    this))

(defn new-component []
  (map->HttpRoutesComponent {}))
