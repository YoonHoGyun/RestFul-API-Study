FROM openjdk:17-jdk

COPY build/libs/*SNAPSHOT.jar ekp.jar

ENTRYPOINT ["java", "-jar", "/ekp.jar"]