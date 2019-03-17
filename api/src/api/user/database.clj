(ns api.user.database
  (:require [clojure.java.jdbc :as jdbc]))

(defn create-user! [db user]
  (let [insert-result (jdbc/insert! db :users user)
        first-result (first insert-result)
        id (:generated_key first-result)]
    (assoc user :id id)))

(defn find-user-by-credentials [db {:keys [email password]}]
  (-> db
    (jdbc/query ["select * from users where email = ? and password = ?" email password])
    first))
