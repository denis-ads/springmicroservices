Curso Udacity

Configuraçao segurança java

download
http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

copiar arquivos para /Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/security

local_policy.jar
US_export_policy.jar

Exportar variavel de ambiente:

export ENCRYPT_KEY=IMSYMMETRIC

chamar api do config server para recuperar a senha criptografada.
	post
	http://localhost:8888/encrypt
	
	body
		{senha do banco}

Configurar variavel no eclispse
Boot dashboard-> open config (Projeto configServer) -> environment 
	Adicionar
		name=ENCRYPT_KEY
		value=IMSYMMETRIC


Log 
https://papertrailapp.com/systems/setup?type=system&platform=osx


http://localhost:9411/zipkin/



docker build -t rabbitmq --file `pwd`/Dockerfile `pwd`

http://localhost:8080//hystrix
Hystrix Stream: http://localhost:8989


docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672  rabbitmq:3-management

http://localhost:15672/


####construir container docker com plugin maven
#caso de algum problema
export DOCKER_HOST=unix:///private/var/tmp/docker.sock
ou 
export DOCKER_HOST=unix:///var/run/docker.sock mvn clean package docker:build
#####

entrar no projeto itemsaring.eurekaserver
mvn clean package docker:build


docker build -t mysql --file `pwd`/Dockerfile `pwd`

docker run --name="logspout" \
	gliderlabs/logspout \
	syslog+tls://logs6.papertrailapp.com:12981


docker run --name="logspout" \
	--volume=/var/run/docker.sock:/var/run/docker.sock \
	gliderlabs/logspout \
	syslog+tls://logs6.papertrailapp.com:12981
	
	

export ZIPKINSERVER_URI=zipkinservice 
export CONFIGSERVER_URI=configservice
export ENCRYPT_KEY=IMSYMMETRIC


docker network create --subnet=172.18.0.0/16 microservicesNet

docker run --name mysql -i -t --rm -p 3306:3306 -h mysql --net microservicesNet -e MYSQL_ROOT_PASSWORD=mysql123 -e MYSQL_DATABASE=itemsharingdatabase -d mysql:latest

docker run --name configservice -i -t --rm -p 8888:8888 -h configservice --net microservicesNet -d configservice 
docker run --name eurekaservice -i -t --rm -p 8761:8761 -h eurekaservice --net microservicesNet -d eurekaservice
docker run --name zipkinservice -i -t --rm -p 9411:9411 -h zipkinservice --net microservicesNet -d zipkinservice
docker run --name zuulservice  -i -t --rm  -p 5555:5555 -h zuulservice --net microservicesNet -d zuulservice
docker run --name authorizationservice -i -t --rm -p 8901:8901 -h authorizationservice --net microservicesNet -d authorizationservice
docker run --name itemservice -i -t --rm -p 8082:8082 -h itemservice --net microservicesNet -d itemservice
docker run --name userservice -i -t --rm -p 8081:8081 -h userservice --net microservicesNet -d userservice


descobrir service que esta usando a porta
lsof -i:8901

https://hub.docker.com/
docker login
denisapolinario
Senha: padrao


$ docker login
<enter user name and password for Docker Hub Repository>

$ docker tag first-image {docker-hub-username}/{default-repo-folder-name}:first-image

$ docker push {docker-hub-username}/{default-repo-folder-name}:first-image

mvn clean package docker:build

docker tag configservice denisapolinario/configservice:1.0.1
docker push denisapolinario/configservice:1.0.1

docker tag eurekaservice denisapolinario/eurekaservice:1.0.0
docker push denisapolinario/eurekaservice:1.0.0


docker tag zipkinservice denisapolinario/zipkinservice:1.0.1
docker push denisapolinario/zipkinservice:1.0.1

docker tag zuulservice denisapolinario/zuulservice:1.0.1
docker push denisapolinario/zuulservice:1.0.1

docker tag authorizationservice denisapolinario/authorizationservice:1.0.1
docker push denisapolinario/authorizationservice:1.0.1

docker tag itemservice denisapolinario/itemservice:1.0.1
docker push denisapolinario/itemservice:1.0.1

docker tag userservice denisapolinario/userservice:1.0.1
docker push denisapolinario/userservice:1.0.1



docker-compose down
docker-compose -f docker-compose.yml -f docker-compose.dev.yml up -d








