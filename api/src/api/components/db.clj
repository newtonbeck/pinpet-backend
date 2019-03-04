(ns api.components.db
  (:import (com.mchange.v2.c3p0 ComboPooledDataSource))
  (:require [com.stuartsierra.component :as component]))

(defrecord DBComponent [config]
  component/Lifecycle

  (start [this]
    (let [url (get-in config [:config :db-url])
          driver-classname (get-in config [:config :db-driver-classname])
          user (get-in config [:config :db-user])
          password (get-in config [:config :db-password])
          db (doto (ComboPooledDataSource.)
                (.setDriverClass driver-classname)
                (.setJdbcUrl url)
                (.setUser user)
                (.setPassword password)
                (.setMaxIdleTimeExcessConnections (* 30 60))
                (.setMaxIdleTime (* 3 60 60 )))]
      (assoc this :db db)))

  (stop [this]
    this))

(defn new-component []
  (map->DBComponent {}))
