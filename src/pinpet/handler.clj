(ns pinpet.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-body]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (POST "/api/login" request
    (let [email (get-in request [:body "email"])
          password (get-in request [:body "password"])]
      (str email password)))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
    wrap-json-body
    (wrap-defaults api-defaults)))
