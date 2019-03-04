(ns api.components.http-server
  (:require [com.stuartsierra.component :as component]
            [ring.adapter.jetty :refer [run-jetty]]
            [api.http.routes :refer [make-handler]]))

(defrecord HttpServerComponent [config db]
  component/Lifecycle

  (start [this]
    (let [port-as-text (get-in config [:config :http-port])
          port (Integer/parseInt port-as-text)
          options {:port port :join? false}
          db-pool (:db db)
          http-server (run-jetty (make-handler db-pool) options)]
      (assoc this :http-server http-server)))

  (stop [this]
    this))

(defn new-component []
  (map->HttpServerComponent {}))
