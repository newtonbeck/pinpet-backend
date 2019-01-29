(ns pinpet-api.pet.database
  (:require [pinpet-api.config :refer [read-config]]
  [clojure.java.jdbc :as jdbc]))

(defn find-pets-by-user [{:keys [id]}]
  (-> (read-config)
    :db
    (jdbc/query ["select * from pets where user_id = ?" id])))
