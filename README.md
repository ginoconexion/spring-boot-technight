# Spring boot microservices

## Prerequisites

### Install RabbitMQ Server :

follow theses instructions to install RabbitMQ Server 
 - for Debian :
```bash
echo 'deb http://www.rabbitmq.com/debian/ testing main' | sudo tee /etc/apt/sources.list.d/rabbitmq.list
         
wget -O- https://www.rabbitmq.com/rabbitmq-release-signing-key.asc | sudo apt-key add -
sudo apt-get update
sudo apt-get install rabbitmq-server
```
 - for OSX
 ```bash
 brew update
 brew install rabbitmq
 ```
To run rabbitMQ server use : `rabbitmq-server`. You may add `/usr/local/sbin` to your path variable.
For more information go to RabitMQ official site : https://www.rabbitmq.com/


Clone following git repository : **https://github.com/ginoconexion/microservices-config.git** containing micro-services configuration

Modify property **spring.cloud.config.server.git.uri** in **config-service/main/resources/application.properties**, and indicate where your git config epository is located in your filesystem.

## Run the services :
Launch Config-service, Eureka-Service, Computer-Service, Application-client by running the SpringApplication class.

## Learn about microservices :
You can learn a bit about the tools we used in the following presentation http://slides.com/lucascoatanlem/sbms#/
