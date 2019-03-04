(ns api.location.database
  (:require [clojure.java.jdbc :as jdbc]))

(defn find-location-of-pet [db {:keys [id]}]
  (-> db
    (jdbc/query ["select * from locations where pet_id = ? order by id desc limit 1" id])
    first))
