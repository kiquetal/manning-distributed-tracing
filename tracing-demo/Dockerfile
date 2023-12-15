FROM eclipse-temurin:17-alpine
VOLUME /tmp
ENV NAME "tracing-demo-0.0.1-SNAPSHOT"
ARG JAR_FILE=build/libs/$NAME.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]
