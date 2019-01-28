(ns pinpet.login.security)

(defn user->token [user]
  (:id user))
