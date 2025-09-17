FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY target/RestApiCalculator-0.0.1-SNAPSHOT.jar /app/RestApiCalculator-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "RestApiCalculator-0.0.1-SNAPSHOT.jar"]
