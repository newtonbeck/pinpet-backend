(ns api.components.http-handler
  (:require [com.stuartsierra.component :as component]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.jwt :refer [wrap-jwt]]))

(defn- wrap-app-component [f db]
  (fn [request]
    (f (assoc request :db db))))

(defn- make-handler [routes db jwt-secret]
  (-> routes
    (wrap-app-component db)
    (wrap-jwt {:alg :HS256 :secret jwt-secret})
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))

(defrecord HttpHandlerComponent [config db http-routes]
  component/Lifecycle
  
  (start [this]
    (let [db-pool (:db db)
          routes (:http-routes http-routes)
          jwt-secret (get-in config [:config :jwt-secret])
          handler (make-handler routes db-pool jwt-secret)]
      (assoc this :http-handler handler)))

  (stop [this]
    this))

(defn new-component []
  (map->HttpHandlerComponent {}))
