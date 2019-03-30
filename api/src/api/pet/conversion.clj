(ns api.pet.conversion
  (:require [ring.util.response :as ring-response]))

(defn pets->response [pets]
  (ring-response/response pets))
