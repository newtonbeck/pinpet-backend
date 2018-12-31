(ns pinpet.login.security-test
  (:use [midje.sweet])
  (:require [pinpet.login.security :as security]))

(def email "luke@rebels.org")

(facts "user->token"
  (fact "with token"
    (security/user->token {:email email}) => email))