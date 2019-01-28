(ns pinpet.location.database)

(defn find-location-of-pet [pet]
  (assoc pet :location {:latitude -23.5625172, :longitude -46.6935706}))
