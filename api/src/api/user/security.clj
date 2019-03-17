(ns api.user.security)

(defn user->token [user]
  (:id user))
