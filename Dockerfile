FROM maven:3.6.0-jdk-11-slim AS build

COPY src src
COPY pom.xml .
VOLUME /root/.m2/repository
RUN mvn -f pom.xml clean package install


FROM openjdk:12-jdk-alpine

COPY --from=build /target /opt/target

WORKDIR /target

ADD ./task.jar task.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/task.jar"]
