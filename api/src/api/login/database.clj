(ns api.login.database
  (:require [api.config :refer [read-config]]
            [clojure.java.jdbc :as jdbc]))

(defn find-user-by-credentials [{:keys [email password]}]
  (-> (read-config)
    :db
    (jdbc/query ["select * from users where email = ? and password = ?" email password])
    first))
