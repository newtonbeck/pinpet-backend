(ns api.security.jwt-spec
  (:use midje.sweet)
  (:require [api.security.jwt :as jwt]))

(facts "jwt"
  (fact "returns claims value when request has claims map"
    (jwt/claims {:claims {:sub 1 :name "Luke Skywalker"}}) => {:sub 1 :name "Luke Skywalker"})
  (fact "returns nil value when request does not have claims map"
    (jwt/claims {}) => nil))