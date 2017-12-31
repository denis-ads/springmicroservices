echo "*************************************************"
echo "Staring zipkin server"
echo "*************************************************"
java -Djava.security.egd=file:/dev./urandom -Xmx256m -Dspring.profiles.active=docker -jar /usr/local/zipkinservice/@project.build.finalName@.jar