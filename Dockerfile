FROM openjdk:17-jdk-alpine
COPY target/API-0.0.1-SNAPSHOT.jar api.jar
ENTRYPOINT ["java","-jar","api.jar"]
