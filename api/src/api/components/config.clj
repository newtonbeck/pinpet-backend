(ns api.components.config
  (:require [com.stuartsierra.component :as component]
            [environ.core :refer [env]]))

(def env-var-names
  [:db-url
   :db-driver-classname
   :db-user
   :db-password
   :http-port])

(defn- read-env-var [env-var-name]
  [env-var-name (env env-var-name)])

(defn load-config []
  (->> env-var-names
    (map read-env-var)
    (flatten)
    (apply assoc {})))

(defrecord Config []
  component/Lifecycle

  (start [this]
    this)

  (stop [this]
    this))

(defn new-component
  map->Config {})
