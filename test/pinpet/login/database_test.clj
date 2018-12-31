(ns pinpet.login.database-test
  (:use [midje.sweet])
  (:require [pinpet.login.database :as database]))

(def email "luke@rebels.org")
(def password "x-wing")

(facts "find-user-by-credentials"
  (fact "existing credentials"
    (database/find-user-by-credentials {:email email, :password password}) => {:email email, :password password})
    (fact "unexisting credentials"
      (database/find-user-by-credentials {:email "foo@bar.org", :password password}) => nil))
