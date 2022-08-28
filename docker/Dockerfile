FROM maven:3.8.6-openjdk-11 as build-stage

WORKDIR /app
COPY . .

RUN mvn clean package

FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
COPY --from=build-stage /app/target/mailing-*.jar /app/mailing.jar

ENTRYPOINT ["java", "-jar", "/app/mailing.jar"]
