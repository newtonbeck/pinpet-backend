(defproject api "0.1.0-SNAPSHOT"
  :description "API for Pinpet's mobile app"
  :url "http://api.pinpet.com.br/ops/health"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.stuartsierra/component "0.4.0"]
                 [ring "1.7.1"]
                 [environ "1.1.0"]
                 [com.mchange/c3p0 "0.9.5.3"]
                 [ovotech/ring-jwt "0.1.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.4.0"]
                 [org.clojure/java.jdbc "0.7.8"]
                 [mysql/mysql-connector-java "5.1.47"]
                 [crypto-password "0.2.1"]]
  :main ^:skip-aot api.main
  :profiles
  {:dev {:uberjar {:aot :all}
         :dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]
                        [midje "1.9.3"]]}})
