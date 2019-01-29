(ns pinpet-api.location.controller
  (:require [pinpet.pet.database :as pet-database]
            [pinpet.location.database :as location-database]))

(defn find-pets-locations-by-user [user]
  (->> user
    pet-database/find-pets-by-user
    (map location-database/find-location-of-pet)))
