(ns pinpet-consumer.location.conversion
  (:require [clojure.data.json :as json]))

(def encoding "UTF-8")

(defn payload->location [payload]
  (let [json (String. payload encoding)
        location (json/read-str json)
        latitude (get location "lat")
        longitude (get location "lon")
        height (get location "hei")
        pet (get location "pet")]
    {:lat latitude, :lon longitude, :hei height, :pet pet}))
