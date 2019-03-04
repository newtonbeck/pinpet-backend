(ns api.components.config
  (:require [com.stuartsierra.component :as component]
            [environ.core :refer [env]]))

(def env-var-keys
  [:db-url
   :db-driver-classname
   :db-user
   :db-password
   :http-port])

(defn- read-env-var [env-var-key env-var-reader]
  [env-var-key (env-var-reader env-var-key)])

(defn load-config [env-var-reader]
  (->> env-var-keys
    (map #(read-env-var % env-var-reader))
    (flatten)
    (apply assoc {})))

(defrecord ConfigComponent []
  component/Lifecycle

  (start [this]
    (let [config (load-config env)]
      (assoc this :config config)))

  (stop [this]
    this))

(defn new-component []
  (map->ConfigComponent {}))
