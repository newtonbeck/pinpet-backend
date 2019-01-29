(defproject pinpet "0.1.0-SNAPSHOT"
  :description "MQTT consumer for Pinpet"
  :url "http://api.pinpet.com.br"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clojurewerkz/machine_head "1.0.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/java.jdbc "0.7.8"]
                 [mysql/mysql-connector-java "5.1.47"]]
  :main ^:skip-aot pinpet-consumer.consumer
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.2"]
                                  [midje "1.9.3"]]}})
