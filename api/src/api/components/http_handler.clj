(ns api.components.http-handler
  (:require [com.stuartsierra.component :as component]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.jwt :refer [wrap-jwt]]))

(defn- wrap-app-component [f config db]
  (fn [request]
    (f (assoc request :config config :db db))))

(defn- make-handler [config db http-routes]
  (-> http-routes
    (wrap-app-component config db)
    (wrap-jwt {:alg :HS256 :secret (:jwt-secret config)})
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))

(defrecord HttpHandlerComponent [config-component db-component http-routes-component]
  component/Lifecycle
  
  (start [this]
    (let [config (:config config-component)
          db (:db db-component)
          http-routes (:http-routes http-routes-component)
          handler (make-handler config db http-routes)]
      (assoc this :http-handler handler)))

  (stop [this]
    this))

(defn new-component []
  (map->HttpHandlerComponent {}))
