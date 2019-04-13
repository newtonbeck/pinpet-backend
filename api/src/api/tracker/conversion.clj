(ns api.tracker.conversion)

(defn request->tracker-on-pet [request]
  (let [tracker-code (get-in request [:body "tracker_code"])
        pet-id (get-in request [:body "pet_id"])]
    {:tracker_code tracker-code, :pet_id pet-id}))
