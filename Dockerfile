FROM maven:3.9.5-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/serverHelper-0.0.1-SNAPSHOT.jar app.jar

ENV DISCORD_BOT_TOKEN=${DISCORD_BOT_TOKEN}

CMD ["java", "-jar", "app.jar"]

