(ns api.components.system
  (:require [com.stuartsierra.component :as component]
            [api.components.config :as config]
            [api.components.db :as db]
            [api.components.http-handler :as http-handler]
            [api.components.http-server :as http-server]
            [api.components.http-routes :as http-routes]))

(defn new-system []
  (component/system-map
    :config (config/new-component)
    :db (component/using (db/new-component) [:config])
    :http-routes (http-routes/new-component)
    :http-handler (component/using (http-handler/new-component) [:config :db :http-routes])
    :http-server (component/using (http-server/new-component) [:config :http-handler])))
