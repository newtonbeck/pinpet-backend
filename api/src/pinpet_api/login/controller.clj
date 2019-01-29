(ns pinpet-api.login.controller
  (:require [pinpet-api.login.database :as db]
            [pinpet-api.login.security :as security]))

(defn log-in [credentials]
  (-> credentials
      db/find-user-by-credentials
      security/user->token))
