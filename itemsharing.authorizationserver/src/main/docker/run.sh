echo "*************************************************"
echo "Staring authorization server"
echo "*************************************************"
java -Djava.security.egd=file:/dev./urandom -Xmx256m -Dspring.profiles.active=docker -jar /usr/local/authorizationservice/@project.build.finalName@.jar