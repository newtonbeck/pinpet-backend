(ns pinpet-consumer.config
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def file "config.edn")

(defn read-config []
  (-> file
    io/resource
    slurp
    edn/read-string))
