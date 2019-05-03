FROM openjdk:8-jdk-alpine AS base
WORKDIR /app
EXPOSE 8080

FROM base AS final
ARG APP_VERSION
WORKDIR /app
ARG JAR_FILE=/build/libs/providerAPI-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","./app.jar"]