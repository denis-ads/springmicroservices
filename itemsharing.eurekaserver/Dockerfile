FROM openjdk:8-jdk-alpine
MAINTAINER Denis Apolinario
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/eurekaservice
ADD ./target/itemsharing.eurekaserver-1.0.1-SNAPSHOT.jar /usr/local/eurekaservice
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh