#!/bin/sh
echo "********************************************************"
echo "Starting zuul server "
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Xmx256m -Dspring.profiles.active=docker -jar /usr/local/zuulservice/@project.build.finalName@.jar

