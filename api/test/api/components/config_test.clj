(ns api.components.config-test
  (:use midje.sweet)
  (:require [api.components.config :refer [load-config]]))

(def env-vars-mock
  {:db-url              "a"
  :db-driver-classname  "b"
  :db-user              "c"
  :db-password          "d"
  :http-port            "e"
  :jwt-secret           "f"})

(defn env-mock [env-var-key]
  (get env-vars-mock env-var-key))


(fact "config loading produces a config map"
  (load-config env-mock) => env-vars-mock)
