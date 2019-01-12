FROM openjdk:11

WORKDIR /pinpet

ADD target/pinpet-0.1.0-SNAPSHOT-standalone.jar /pinpet

EXPOSE 3000

ENTRYPOINT "java -jar pinpet-0.1.0-SNAPSHOT-standalone.jar"
