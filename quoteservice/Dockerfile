FROM amazoncorretto:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} quote.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/quote.jar"]