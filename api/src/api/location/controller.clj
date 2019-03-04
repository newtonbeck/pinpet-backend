(ns api.location.controller
  (:require [api.pet.database :as pet-database]
            [api.location.database :as database]
            [api.location.conversion :as conversion]))

(defn find-pet-locations [request]
  (->> request
    (conversion/request->user)
    (pet-database/find-pets-by-user (:db request))
    (map #(assoc % :location (database/find-location-of-pet (:db request) %)))
    (conversion/pets->response)))
