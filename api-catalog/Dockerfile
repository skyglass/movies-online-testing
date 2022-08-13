FROM openjdk:17-alpine

COPY src/conf application/

COPY target/api-catalog-*.jar application/api-catalog.jar

CMD java --add-opens=java.base/java.lang=ALL-UNNAMED -jar application/api-catalog.jar --spring.config.location=application/docker/application.yml

EXPOSE 6070