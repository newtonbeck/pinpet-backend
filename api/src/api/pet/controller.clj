(ns api.pet.controller
  (:require [ring.util.response :as ring-response]
            [api.pet.conversion :as conversion]
            [api.pet.database :as database]
            [api.security.jwt :as jwt]))

(defn list-my-pets [request]
  (if-let [claims (jwt/claims? request)]
    (->> claims
      (jwt/claims->user)
      (database/find-pets-by-user (:db request))
      (ring-response/response))
    {:status 401}))

(defn find-my-pets-locations [request]
  (if-let [claims (jwt/claims? request)]
    (->> claims
      (jwt/claims->user)
      (database/find-pets-by-user-with-tracker (:db request))
      (map #(assoc % :location (database/find-pet-location (:db request) %)))
      (ring-response/response))
    {:status 401}))

(defn create-pet [request]
  (if-let [claims (jwt/claims? request)]
    (->> claims
      (jwt/claims->user)
      (conversion/request-&-user->pet request)
      (database/create-pet! (:db request))
      (ring-response/response))
    {:status 401}))
