FROM openjdk:17-jdk-alpine

ARG JAR_FILE=./target/*.jar

COPY ${JAR_FILE} bookstore.jar

CMD ["java", "-Dserver.port=8080", "-Duser.timezone=UTC", "-jar", "bookstore.jar"]

EXPOSE 8080
