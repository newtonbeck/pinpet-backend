(ns api.log-in.database
  (:require [api.config :refer [read-config]]
            [clojure.java.jdbc :as jdbc]))

(defn find-user-by-credentials [db {:keys [email password]}]
  (-> db
    (jdbc/query ["select * from users where email = ? and password = ?" email password])
    first))
