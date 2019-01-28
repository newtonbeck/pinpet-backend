(ns pinpet.login.security-test
  (:use [midje.sweet])
  (:require [pinpet.login.security :as security]))

(facts "user->token"
  (fact "with token"
    (security/user->token {:id 1}) => 1)
  (fact "without token"
    (security/user->token nil) => nil))
