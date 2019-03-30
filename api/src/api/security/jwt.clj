(ns api.security.jwt
  (:import [com.auth0.jwt.algorithms Algorithm]
           [com.auth0.jwt JWT]))

(defn claims? [request]
  (let [claims (:claims request)]
    (if (empty? claims) nil claims)))

(defn claims->user [claims]
  (let [id (:sub claims)
        name (:name claims)]
    {:id id :name name}))

(defn create-token [secret user]
  (let [id-as-number (:id user)
        id-as-text (str id-as-number)
        name (:name user)
        algorithm (Algorithm/HMAC256 secret)]
    (-> (JWT/create)
      (.withSubject id-as-text)
      (.withClaim "name" name)
      (.sign algorithm))))
