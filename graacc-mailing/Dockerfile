FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/graacc-mailing-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
