#
# Oracle Java 9 Dockerfile
#
# https://github.com/cogniteev/docker-oracle-java
# https://github.com/cogniteev/docker-oracle-java/tree/master/oracle-java9
#

# Pull base image.
FROM ubuntu:17.10

VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
