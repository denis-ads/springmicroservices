FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER Denis Apolinario
RUN export ENCRYPT_KEY=IMSYMMETRIC
RUN mkdir -p /usr/local/userservice
ADD @project.build.finalName@.jar /usr/local/userservice
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh