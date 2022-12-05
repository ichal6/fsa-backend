FROM openjdk:17-jdk-slim-buster
WORKDIR /app
EXPOSE 8080

COPY build/libs/fsa-backend*-SNAPSHOT.jar fsa-backend.jar
CMD [ "java", "-jar", "-Dspring.profiles.active=dev", "fsa-backend.jar"]

