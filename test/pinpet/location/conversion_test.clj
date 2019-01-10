(ns pinpet.location.conversion-test
  (:use midje.sweet)
  (:require [pinpet.location.conversion :as conversion]))

(facts "request->user"
  (fact "with token"
    (conversion/request->user {:headers {"Authorization" "123"}}) => {:id 123})
  (fact "without token"
    (conversion/request->user {:headers {}}) => (throws NumberFormatException)))
