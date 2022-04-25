FROM amazoncorretto:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} claims.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/claims.jar"]