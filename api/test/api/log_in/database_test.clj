(ns api.log-in.database-test
  (:use [midje.sweet])
  (:require [api.log-in.database :as database]))

(def id 1)
(def name "Luke Skywalker")
(def email "luke@rebels.org")
(def password "x-wing")

; (facts "find-user-by-credentials"
;   (fact "existing credentials"
;     (database/find-user-by-credentials {:email email, :password password}) => {:id id, :name name, :email email, :password password})
;     (fact "unexisting credentials"
;       (database/find-user-by-credentials {:email "foo@bar.org", :password password}) => nil))
