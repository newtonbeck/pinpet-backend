(ns api.components.system
  (:require [com.stuartsierra.component :as component]
            [api.components.http-server :as http-server]))

(defn new-system []
  (component/system-map
    :http-server (component/using (http-server/new-component) [])))
