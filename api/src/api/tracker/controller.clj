(ns api.tracker.controller
  (:require [ring.util.response :as ring-response]
            [api.tracker.conversion :as conversion]))

(defn put-tracker-on-pet [request]
  (-> request
    conversion/request->tracker-on-pet
    println)
  (ring-response/response {}))
