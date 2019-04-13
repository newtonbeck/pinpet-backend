(ns api.tracker.conversion-test
  (:use midje.sweet)
  (:require [api.tracker.conversion :as conversion]))

(facts "request->tracker-on-pet"
  (fact "should convert request body to tracker-on-pet map"
    (conversion/request->tracker-on-pet {:body {"tracker_code" 123456, "pet_id" 1}}) => {:tracker_code 123456, :pet_id 1}))

