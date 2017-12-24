#FROM openjdk:8-jdk-alpine
#FROM 8_server-jre_unlimited
FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER Denis Apolinario
RUN export ENCRYPT_KEY=IMSYMMETRIC
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/configservice
ADD @project.build.finalName@.jar /usr/local/configservice
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh