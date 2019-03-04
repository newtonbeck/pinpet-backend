(ns api.components.http-server
  (:require [com.stuartsierra.component :as component]
            [ring.adapter.jetty :refer [run-jetty]]
            [api.http.routes :refer [api-routes]]))

(defrecord HttpServerComponent [config]
  component/Lifecycle

  (start [this]
    (let [port-as-text (get-in config [:config :http-port])
          port (Integer/parseInt port-as-text)
          options {:port port :join? false}
          http-server (run-jetty api-routes options)]
      (assoc this :http-server http-server)))

  (stop [this]
    this))

(defn new-component []
  (map->HttpServerComponent {}))
