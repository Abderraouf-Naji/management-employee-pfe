FROM maven:3-openjdk-17-slim as build

RUN mkdir -p /workspace

WORKDIR /workspace

COPY pom.xml /workspace

COPY src /workspace/src

RUN mvn -f pom.xml clean package -DskipTests
# RUN mvn clean package

FROM openjdk:18
COPY --from=build /workspace/target/*.jar app.jar
# COPY  ./target/*.jar /app/
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
