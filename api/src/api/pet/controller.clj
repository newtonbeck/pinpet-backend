(ns api.pet.controller
  (:require [api.pet.conversion :as conversion]
            [api.pet.database :as database]
            [api.security.jwt :as jwt]))

(defn list-my-pets [request]
  (if-let [claims (jwt/claims? request)]
    (->> claims
      (jwt/claims->user)
      (database/find-pets-by-user (:db request))
      (conversion/pets->response))
    {:status 401}))

(defn find-my-pets-locations [request]
  (if-let [claims (jwt/claims? request)]
    (->> claims
      (jwt/claims->user)
      (database/find-pets-by-user (:db request))
      (map #(assoc % :location (database/find-pet-location (:db request) %)))
      (conversion/pets->response))
    {:status 401}))
