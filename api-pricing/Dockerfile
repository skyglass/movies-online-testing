FROM openjdk:17-alpine

COPY src/conf application/

COPY target/api-pricing-*.jar application/api-pricing.jar

CMD java --add-opens=java.base/java.lang=ALL-UNNAMED -jar application/api-pricing.jar --spring.config.location=application/docker/application.yml

EXPOSE 5070