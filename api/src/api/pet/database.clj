(ns api.pet.database
  (:require [clojure.java.jdbc :as jdbc]))

(defn find-pets-by-user [db {:keys [id]}]
  (jdbc/query db ["select * from pets where user_id = ?" id]))

(defn find-pet-location [db {:keys [id]}]
  (-> db
    (jdbc/query ["select * from locations where pet_id = ? order by id desc limit 1" id])
    first))