(ns api.security.jwt-spec
  (:use midje.sweet)
  (:require [api.security.jwt :as jwt]))

(facts "claims?"
  (fact "returns claims value when request has claims map"
    (jwt/claims? {:claims {:sub 1 :name "Luke Skywalker"}}) => {:sub 1 :name "Luke Skywalker"})
  (fact "returns nil value when request has an empty claims map"
    (jwt/claims? {:claims {}}) => nil))

(facts "claims->user"
  (fact "returns user from claims"
    (jwt/claims->user {:sub 1 :name "Luke Skywalker"}) => {:id 1 :name "Luke Skywalker"}))
