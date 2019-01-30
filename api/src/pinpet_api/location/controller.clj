(ns pinpet-api.location.controller
  (:require [pinpet-api.pet.database :as pet-database]
            [pinpet-api.location.database :as location-database]))

(defn find-pets-locations-by-user [user]
  (->> user
    pet-database/find-pets-by-user
    (map #(assoc % :location (location-database/find-location-of-pet %)))))
