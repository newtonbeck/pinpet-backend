(ns pinpet.login.database
  (:require [pinpet.config :as config]
            [clojure.java.jdbc :as jdbc]))

(def db [{:email "luke@rebels.org", :password "x-wing"}])

(defn find-user-by-credentials [credentials]
  (let [email (:email credentials)
        password (:password credentials)]
    (jdbc/query ["select * from users where email = ? and password = ?"] email password)))
