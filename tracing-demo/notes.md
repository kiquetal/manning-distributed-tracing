#### Just to pass the arguments from docker run you need to use
 ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]

