(ns pinpet-consumer.location.database
  (:require [clojure.java.jdbc :as jdbc]
            [pinpet-consumer.config :refer [read-config]]))

(defn add-location! [location]
  (-> (read-config)
    :db
    (jdbc/insert! :locations location)))
