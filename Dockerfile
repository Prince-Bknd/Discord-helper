FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build target/serverHelper.jar ./serverHelper.jar

ENV DISCORD_BOT_TOKEN=${DISCORD_BOT_TOKEN}

CMD ["java", "-jar", "serverHelper.jar"]
