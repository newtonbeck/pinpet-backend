(ns pinpet.login.database)

(def db [{:email "luke@rebels.org", :password "x-wing"}])

(defn find-user-by-credentials [credentials]
  (->> db
    (filter (partial = credentials))
    first))