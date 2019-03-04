(ns api.log-in.security)

(defn user->token [user]
  (:id user))
