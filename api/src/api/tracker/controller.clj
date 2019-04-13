(ns api.tracker.controller
  (:require [ring.util.response :as ring-response]
            [api.tracker.conversion :as conversion]
            [api.tracker.database :as tracker-database]
            [api.pet.database :as pet-database]))

(defn put-tracker-on-pet [request]
  (let [db (:db request)
        tracker-on-pet (conversion/request->tracker-on-pet request)
        tracker-code (:tracker_code tracker-on-pet)
        tracker (tracker-database/find-tracker-by-code db tracker-code)
        pet-id (:pet_id tracker-on-pet)
        pet (pet-database/find-pet-by-id db pet-id)
        pet-with-tracker (pet-database/put-tracker-on-pet! db tracker pet)]
    (ring-response/response pet-with-tracker)))
