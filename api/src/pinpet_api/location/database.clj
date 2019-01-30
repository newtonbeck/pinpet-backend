(ns pinpet-api.location.database
  (:require [pinpet-api.config :refer [read-config]]
            [clojure.java.jdbc :as jdbc]))

(defn find-location-of-pet [{:keys [id]}]
  (-> (read-config)
    :db
    (jdbc/query ["select * from locations where pet_id = ? order by id desc limit 1" id])))
