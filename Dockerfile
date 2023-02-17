FROM openjdk:17-jdk-alpine
LABEL maintainer="Hani"
ADD target/user-0.0.1-SNAPSHOT.jar userMicro.jar
ENTRYPOINT ["java", "-jar", "userMicro.jar"]
