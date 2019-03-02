(ns api.components.http-server
  (:require [com.stuartsierra.component :as component]))

(defrecord HttpServerComponent []
  component/Lifecycle
  
  (start [this]
    (println "Starting http component...")
    this)
  
  (stop [this]
    (println "Stopping http component...")
    this))

(defn new-component []
  (map->HttpServerComponent {}))
