FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/serverHelper-0.0.1-SNAPSHOT.jar app.jar

ENV DISCORD_BOT_TOKEN=${DISCORD_BOT_TOKEN}

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
