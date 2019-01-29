(ns pinpet-api.location.database-test
  (:use midje.sweet)
  (:require [pinpet.location.database :as location-database]))

(facts "find-location-by-pet"
  (fact "location exists"
    (location-database/find-location-of-pet {:id 1, :name "Tom", :user_id 1}) => {:id 1, :name "Tom", :user_id 1, :location {:latitude -23.5625172, :longitude -46.6935706}}))