FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER Denis Apolinario
RUN export ENCRYPT_KEY=IMSYMMETRIC
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/zipkinservice
ADD @project.build.finalName@.jar /usr/local/zipkinservice
ADD run.sh run.sh

RUN chown -R 1001:1001 run.sh
RUN chmod +x run.sh
USER 1001
CMD ./run.sh