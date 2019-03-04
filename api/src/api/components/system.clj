(ns api.components.system
  (:require [com.stuartsierra.component :as component]
            [api.components.config :as config]
            [api.components.http-server :as http-server]))

(defn new-system []
  (component/system-map
    :config (config/new-component)
    :http-server (component/using (http-server/new-component) [:config])))
