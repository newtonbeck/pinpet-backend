FROM openjdk:8-alpine

WORKDIR /pinpet

ADD target/uberjar/pinpet-0.1.0-SNAPSHOT-standalone.jar .

ENTRYPOINT java -jar pinpet-0.1.0-SNAPSHOT-standalone.jar
