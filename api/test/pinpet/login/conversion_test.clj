(ns pinpet.login.conversion-test
  (:use midje.sweet)
  (:require [pinpet.login.conversion :as conversion]))

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
