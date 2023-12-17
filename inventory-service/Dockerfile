FROM eclipse-temurin:17-alpine
VOLUME /tmp
ARG NAME="inventory-service-0.0.1-SNAPSHOT"
ARG JAR_FILE=build/libs/${NAME}.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]
