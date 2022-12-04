FROM openjdk:17-jdk-slim-buster
WORKDIR /app
EXPOSE 8080

COPY build/libs/fsa-backend*-SNAPSHOT.jar fsa-backend.jar
CMD [ "java", "-jar",  "fsa-backend.jar"]

