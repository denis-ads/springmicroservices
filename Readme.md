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

