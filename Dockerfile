FROM eclipse-temurin:17

WORKDIR /app

COPY target/microstest-0.1-Release.jar ./microstest.jar

EXPOSE 8080:8080

ENTRYPOINT ["java", "-jar", "/app/microstest.jar"]