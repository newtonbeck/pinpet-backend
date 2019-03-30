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

(def secret "f2b51a05-1f2f-4e83-b99e-c5e93214198d")

(facts "create-token"
  (fact "creates a new JWT token from secret and user"
    (jwt/create-token secret {:id 1 :name "Luke Skywalker"}) => "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwibmFtZSI6Ikx1a2UgU2t5d2Fsa2VyIn0.kwj65geVETSz5wyH083bqwI74WHi-7KUzzDOHyBPjk4"))
