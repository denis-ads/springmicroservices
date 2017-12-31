echo "*************************************************"
echo "Staring config server"
echo "*************************************************"
java -Djava.security.egd=file:/dev./urandom -Xmx256m -jar /usr/local/configservice/@project.build.finalName@.jar