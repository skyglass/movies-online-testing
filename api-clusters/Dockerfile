FROM openjdk:17-alpine

COPY src/conf application/

COPY target/api-clusters-*.jar application/api-clusters.jar

CMD java --add-opens=java.base/java.lang=ALL-UNNAMED -jar application/api-clusters.jar --spring.config.location=application/docker/application.yml

EXPOSE 4070
