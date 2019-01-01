(ns pinpet.login.database
  (:require [pinpet.config :as config]
            [clojure.java.jdbc :as jdbc]))

(defn find-user-by-credentials [{:keys [email password]}]
  (-> (config/read)
    :db
    (jdbc/query ["select * from users where email = ? and password = ?" email password])))
