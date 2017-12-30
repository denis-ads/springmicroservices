echo "*************************************************"
echo "Staring eureka server"
echo "*************************************************"
java -Djava.security.egd=file:/dev./urandom -Dspring.profiles.active=docker -jar /usr/local/eurekaservice/@project.build.finalName@.jar