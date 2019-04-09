(ns api.pet.conversion)

(defn request-&-user->pet [request user]
  (let [name (get-in request [:body "name"])
        id (:id user)]
    {:name name, :user_id id}))