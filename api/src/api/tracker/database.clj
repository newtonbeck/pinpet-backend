(ns api.tracker.database
  (:require [clojure.java.jdbc :as jdbc]))

(defn find-tracker-by-code [db code]
  (-> db
    (jdbc/query ["select * from trackers where code = ?" code])
    first))
