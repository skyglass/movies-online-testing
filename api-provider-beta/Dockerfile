FROM openjdk:17-alpine

COPY src/conf application/

COPY target/api-provider-beta-*.jar application/api-provider-beta.jar

CMD java --add-opens=java.base/java.lang=ALL-UNNAMED -jar application/api-provider-beta.jar --spring.config.location=application/docker/application.yml

EXPOSE 9070