(ns api.pet.database
  (:require [clojure.java.jdbc :as jdbc]))

(defn find-pets-by-user [db {:keys [id]}]
  (jdbc/query db ["select * from pets where user_id = ?" id]))

(defn find-pets-by-user-with-tracker [db {:keys [id]}]
  (jdbc/query db ["select * from pets where user_id = ? and tracker_id is not null" id]))

(defn find-pet-location [db {:keys [tracker_id]}]
  (-> db
    (jdbc/query ["select * from trackers_events where tracker_id = ? order by id desc limit 1" tracker_id])
    first))

(defn create-pet! [db pet]
  (let [insert-result (jdbc/insert! db :pets pet)
        first-result (first insert-result)
        id (:generated_key first-result)]
    (assoc pet :id id)))
