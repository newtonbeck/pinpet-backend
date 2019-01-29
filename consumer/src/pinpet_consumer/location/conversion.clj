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
    {:latitude latitude, :longitude longitude, :height height, :pet_id pet}))
