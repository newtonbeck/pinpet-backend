(ns pinpet.login.controller
  (:require [pinpet.login.database :as db]
            [pinpet.login.security :as security]))

(defn log-in [credentials]
  (-> credentials
      db/find-user-by-credentials
      security/user->token))
