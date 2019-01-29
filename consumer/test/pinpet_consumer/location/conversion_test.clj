(ns pinpet-consumer.location.conversion-test
  (:use midje.sweet)
  (:require [pinpet-consumer.location.conversion :as conversion]))

(def payload (.getBytes "{\"lat\": 1.23, \"lon\": 4.56, \"hei\": 7.89, \"pet\": 1 }"))

(facts "payload->location"
  (fact "json payload"
    (conversion/payload->location payload) => {:latitude 1.23 :longitude 4.56 :height 7.89 :pet_id 1}))