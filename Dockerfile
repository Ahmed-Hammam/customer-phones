FROM openjdk:8-jdk-alpine
COPY target/phone-numbers-0.0.1-SNAPSHOT.jar phone-numbers-0.0.1-SNAPSHOT.jar
COPY sample.db sample.db
ENTRYPOINT ["java","-jar","/phone-numbers-0.0.1-SNAPSHOT.jar"]
