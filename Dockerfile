FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} employee-core-api.jar
ENTRYPOINT ["java","-jar","/employee-core-api.jar"]