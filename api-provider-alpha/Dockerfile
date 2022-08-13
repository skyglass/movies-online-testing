FROM openjdk:17-alpine

COPY src/conf application/

COPY target/api-provider-alpha-*.jar application/api-provider-alpha.jar

CMD java --add-opens=java.base/java.lang=ALL-UNNAMED -jar application/api-provider-alpha.jar --spring.config.location=application/docker/application.yml

EXPOSE 8070