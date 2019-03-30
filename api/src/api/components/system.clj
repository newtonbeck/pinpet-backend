(ns api.components.system
  (:require [com.stuartsierra.component :as component]
            [api.components.config :as config]
            [api.components.db :as db]
            [api.components.http-handler :as http-handler]
            [api.components.http-server :as http-server]))

(defn new-system []
  (component/system-map
    :config (config/new-component)
    :db (component/using (db/new-component) [:config])
    :http-handler (component/using (http-handler/new-component) [:config :db])
    :http-server (component/using (http-server/new-component) [:config :http-handler])))
