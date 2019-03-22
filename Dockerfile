FROM openjdk:8-jre
MAINTAINER Ajit MAhajani <ajit.mahajani@xoriant.com>

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/usr/share/myservice/xordemo.jar"]

# Add the service itself
ARG JAR_FILE
COPY target/${JAR_FILE} /usr/share/myservice/xordemo.jar

EXPOSE 8080