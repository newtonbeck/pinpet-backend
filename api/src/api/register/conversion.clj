(ns api.register.conversion)

(defn request->user [request]
  (let [name (get-in request [:body "name"])
        email (get-in request [:body "email"])
        password (get-in request [:body "password"])]
    {:name name, :email email, :password password}))
