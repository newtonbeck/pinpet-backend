(ns api.user.conversion-test
  (:use midje.sweet)
  (:require [api.user.conversion :as conversion]))

(def full-name "Luke Skywalker")
(def email "luke@rebels.org")
(def password "x-wing")
(def token "token")

(facts "request->credentials"
  (fact "with email and password"
    (conversion/request->credentials {:body {"email" email, "password" password}}) => {:email email, :password password})
  (fact "without email"
    (conversion/request->credentials {:body {"email" nil, "password" password}}) => {:email nil, :password password})
  (fact "without password"
    (conversion/request->credentials {:body {"email" email, "password" nil}}) => {:email email, :password nil})
    (fact "without email and password"
      (conversion/request->credentials {:body {"email" nil, "password" nil}}) => {:email nil, :password nil}))

(facts "token->response"
  (fact "with token"
    (conversion/token->response token) => {:body {:token token}, :headers {}, :status 200})
  (fact "without token"
    (conversion/token->response nil) => {:status 401}))

(facts "request->user conversion"
  (fact "converts with name, email and password"
    (conversion/request->user {:body {"name" full-name "email" email "password" password}}) => {:name full-name :email email :password password})
  (fact "converts without name"
    (conversion/request->user {:body {"email" email "password" password}}) => {:name nil :email email :password password})
  (fact "converts without email"
    (conversion/request->user {:body {"name" full-name "password" password}}) => {:name full-name :email nil :password password})
  (fact "converts without password"
    (conversion/request->user {:body {"name" full-name "email" email}}) => {:name full-name :email email :password nil}))
