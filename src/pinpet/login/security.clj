(ns pinpet.login.security)

(defn user->token [user]
  (:email user))
