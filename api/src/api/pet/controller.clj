(ns api.pet.controller
  (:require [api.pet.conversion :as conversion]
            [api.pet.database :as database]))

(defn list-my-pets [request]
  (->> request
    (conversion/request->user)
    (database/find-pets-by-user (:db request))
    (conversion/pets->response)))

(defn find-my-pets-locations [request]
  (->> request
    (conversion/request->user)
    (database/find-pets-by-user (:db request))
    (map #(assoc % :location (database/find-pet-location (:db request) %)))
    (conversion/pets->response)))
