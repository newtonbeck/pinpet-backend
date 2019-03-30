(ns api.security.jwt)

(defn claims? [request]
  (let [claims (:claims request)]
    (if (empty? claims) nil claims)))

(defn claims->user [claims]
  (let [id (:sub claims)
        name (:name claims)]
    {:id id :name name}))
