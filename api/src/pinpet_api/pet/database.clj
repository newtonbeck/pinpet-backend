(ns pinpet-api.pet.database
  (:require [pinpet.config :as config]
  [clojure.java.jdbc :as jdbc]))

(defn find-pets-by-user [{:keys [id]}]
  (-> (config/read)
    :db
    (jdbc/query ["select * from pets where user_id = ?" id])))
