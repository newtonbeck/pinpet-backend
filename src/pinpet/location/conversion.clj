(ns pinpet.location.conversion
  (:require [ring.util.response :as ring-response]))

(defn request->user [request]
  (let [token (ring-response/get-header request "Authorization")
        id (Integer/parseInt token)]
    {:id id}))

(defn locations->response [locations]
  (ring-response/response locations))