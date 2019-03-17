(ns api.user.security-test
  (:use [midje.sweet])
  (:require [api.user.security :as security]))

(facts "user->token"
  (fact "with token"
    (security/user->token {:id 1}) => 1)
  (fact "without token"
    (security/user->token nil) => nil))
