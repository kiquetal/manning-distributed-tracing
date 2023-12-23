FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG NAME="billing-service-0.0.1-SNAPSHOT"
ARG JAR_FILE=build/libs/${NAME}.jar
COPY ${JAR_FILE} app.jar
#ENV JAEGER_ENDPOINT="http://jaeger-service:14268/api/traces"
ENV JAEGER_SAMPLER_TYPE="const"
ENV JAEGER_SAMPLER_PARAM="1"
ENV JAEGER_REPORTER_LOG_SPANS="true"

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]

