(defproject pinpet "0.1.0-SNAPSHOT"
  :description "MQTT consumer for Pinpet"
  :url "http://api.pinpet.com.br"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clojurewerkz/machine_head "1.0.0"]]
  :main ^:skip-aot pinpet-consumer.consumer
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
