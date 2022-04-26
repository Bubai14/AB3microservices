FROM amazoncorretto:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} policy.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/policy.jar"]