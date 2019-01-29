(ns pinpet-consumer.consumer
  (:require [pinpet-consumer.config :refer [read-config]]
            [clojurewerkz.machine-head.client :as mh])
  (:gen-class))

(defn- consume [^String topic _ ^bytes payload]
  (println (String. payload "UTF-8")))

(defn -main
  [& args]
  (let [config (read-config)
        mqtt-config (:mqtt config)
        protocol (:protocol mqtt-config)
        host (:host mqtt-config)
        port (:port mqtt-config)
        topic (:topic mqtt-config)
        connection-string (str protocol "://" host ":" port)
        connection (mh/connect connection-string)]
    (mh/subscribe connection {topic 0} consume)))
