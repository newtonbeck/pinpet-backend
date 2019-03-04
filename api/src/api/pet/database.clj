(ns api.pet.database
  (:require [clojure.java.jdbc :as jdbc]))

(defn find-pets-by-user [db {:keys [id]}]
  (jdbc/query db ["select * from pets where user_id = ?" id]))
