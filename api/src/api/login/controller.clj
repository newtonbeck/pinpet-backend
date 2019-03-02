(ns api.login.controller
  (:require [api.login.database :as db]
            [api.login.security :as security]))

(defn log-in [credentials]
  (-> credentials
      db/find-user-by-credentials
      security/user->token))
