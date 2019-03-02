(ns api.components.http-server
  (:require [com.stuartsierra.component :as component]
            [ring.adapter.jetty :refer [run-jetty]]))

(defn- handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hallo Welt"})

(defrecord HttpServerComponent []
  component/Lifecycle
  
  (start [this]
    (let [options {:port 3000 :join? false}
          http-server (run-jetty handler options)]
      (assoc this :http-server http-server)))
  
  (stop [this]
    (println "Stopping http component...")
    this))

(defn new-component []
  (map->HttpServerComponent {}))
