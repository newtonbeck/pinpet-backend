(ns pinpet.location.controller
  (:require [pinpet.pet.database :as pet-database]))

(defn find-pets-locations-by-user [user]
  (-> user
    pet-database/find-pets-by-user))