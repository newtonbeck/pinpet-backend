(ns api.register.conversion-test
  (:use midje.sweet)
  (:require [api.register.conversion :as conversion]))

(def full-name "Luke Skywalker")
(def email "luke@rebels.org")
(def password "x-wing")

(facts "request->user conversion"
  (fact "converts with name, email and password"
    (conversion/request->user {:body {"name" full-name "email" email "password" password}}) => {:name full-name :email email :password password})
  (fact "converts without name"
    (conversion/request->user {:body {"email" email "password" password}}) => {:name nil :email email :password password})
  (fact "converts without email"
    (conversion/request->user {:body {"name" full-name "password" password}}) => {:name full-name :email nil :password password})
  (fact "converts without password"
    (conversion/request->user {:body {"name" full-name "email" email}}) => {:name full-name :email email :password nil}))
