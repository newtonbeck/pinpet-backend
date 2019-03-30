(ns api.components.http-server
  (:require [com.stuartsierra.component :as component]
            [ring.adapter.jetty :refer [run-jetty]]))

(defrecord HttpServerComponent [config http-handler]
  component/Lifecycle

  (start [this]
    (let [port-as-text (get-in config [:config :http-port])
          port (Integer/parseInt port-as-text)
          options {:port port :join? false}
          handler (:http-handler http-handler)
          http-server (run-jetty handler options)]
      (assoc this :http-server http-server)))

  (stop [this]
    this))

(defn new-component []
  (map->HttpServerComponent {}))
