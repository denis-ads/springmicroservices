#!/bin/sh
echo "********************************************************"
echo "Starting user service "
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Xmx256m -Dspring.profiles.active=docker -jar /usr/local/userservice/@project.build.finalName@.jar

