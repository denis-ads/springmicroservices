FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER Denis Apolinario
RUN export ZIPKINSERVER_URI=zipkinservice
RUN export CONFIGSERVER_URI=configservice
RUN export ENCRYPT_KEY=IMSYMMETRIC
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/zuulservice
ADD @project.build.finalName@.jar /usr/local/zuulservice
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh