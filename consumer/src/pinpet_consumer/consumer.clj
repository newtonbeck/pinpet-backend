(ns pinpet-consumer.consumer
  (:require [clojurewerkz.machine-head.client :as mh]
            [pinpet-consumer.config :refer [read-config]]
            [pinpet-consumer.location.conversion :as conversion]
            [pinpet-consumer.location.database :as db])
  (:gen-class))

(defn- consume [^String topic _ ^bytes payload]
  (-> payload
    (conversion/payload->location)
    (db/add-location!)
    (println)))

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
    (println "Consumer started...")
    (mh/subscribe connection {topic 0} consume)))
