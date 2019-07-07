FROM openjdk:8-jre-alpine
MAINTAINER zhigui.xu
USER root

COPY target/gs-rest-service-0.1.0.jar /apps/greeter.jar
CMD ["/usr/bin/java", "-jar", "/apps/greeter.jar"]
