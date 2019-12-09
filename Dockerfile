FROM maven:3.6-jdk-11 as build
COPY . /src
WORKDIR ./src
RUN mvn install -DskipTests

FROM openjdk:11-jre
COPY --from=build /src/target/*.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
