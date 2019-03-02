(ns api.main
  (:gen-class)
  (:require [com.stuartsierra.component :as component]
            [api.components.system :as system]))

(defn -main []
  (component/start (system/new-system)))
