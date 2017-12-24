#!/bin/sh
echo "********************************************************"
echo "Starting item service "
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /usr/local/itemservice/@project.build.finalName@.jar

