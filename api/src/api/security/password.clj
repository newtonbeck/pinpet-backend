(ns api.security.password
  (:require [crypto.password.bcrypt :as password]))

(defn encrypt [user]
  (let [password (:password user)
        encrypted-password (password/encrypt password)]
    (assoc user :password encrypted-password)))

(defn matches? [user credentials]
  (password/check (:password credentials) (:password user)))
