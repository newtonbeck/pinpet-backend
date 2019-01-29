(ns pinpet-api.login.security)

(defn user->token [user]
  (:id user))
