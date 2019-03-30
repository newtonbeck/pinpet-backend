(ns api.components.http-handler
  (:require [com.stuartsierra.component :as component]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defn- wrap-app-component [f db]
  (fn [request]
    (f (assoc request :db db))))

(defn- make-handler [routes db]
  (-> routes
    (wrap-app-component db)
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))

(defrecord HttpHandlerComponent [config db http-routes]
  component/Lifecycle
  
  (start [this]
    (let [db-pool (:db db)
          routes (:http-routes http-routes)
          handler (make-handler routes db-pool)]
      (assoc this :http-handler handler)))

  (stop [this]
    this))

(defn new-component []
  (map->HttpHandlerComponent {}))
