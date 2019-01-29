(ns pinpet-consumer.location.conversion-test
  (:use midje.sweet)
  (:require [pinpet-consumer.location.conversion :as conversion]))

(def payload (.getBytes "{\"lat\": 1.23, \"lon\": 4.56, \"hei\": 7.89, \"pet\": 1 }"))

(facts "payload->location"
  (fact "json payload"
    (conversion/payload->location payload) => {:lat 1.23 :lon 4.56 :hei 7.89 :pet 1}))