(ns api.tracker.conversion)

(defn request->tracker-on-pet [request]
  (let [tracker-code-as-text (get-in request [:body "tracker_code"])
        tracker-code-as-number (Integer/parseInt tracker-code-as-text)
        pet-id (get-in request [:body "pet_id"])]
    {:tracker_code tracker-code-as-number, :pet_id pet-id}))
