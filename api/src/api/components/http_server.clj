(ns api.components.http-server
  (:require [com.stuartsierra.component :as component]
            [ring.adapter.jetty :refer [run-jetty]]
            [api.handler :refer [app]]))

(defrecord HttpServerComponent []
  component/Lifecycle
  
  (start [this]
    (let [options {:port 3000 :join? false}
          http-server (run-jetty app options)]
      (assoc this :http-server http-server)))
  
  (stop [this]
    (println "Stopping http component...")
    this))

(defn new-component []
  (map->HttpServerComponent {}))
