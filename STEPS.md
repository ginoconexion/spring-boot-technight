# Steps

## Step 1 :

We create the computer-service, mappers and controllers.
Create computer-service, mappers and controllers.

## Step 2 : implement configuration server

To avoid that every services possesses its own configuration and that this configuration would be packaged in the application jar.
A config server will enable to externalize each service configuration.

* create config server
* indicate port where to deploy the app.
* specify git repository location that contains configurations files.
* add @EnableConfigServer on spring boot main class

Once the config server is all set. Computer-service must be adapted :
* specify config server address in properties
* application name 
* rename application.properties to bootstrap.properties (spring-cloud convention)

Config server takes in account the last version on master of the git repository. Therefore, if a property is changed and committed, the config server will takes the last version in account without need of restarting the app.

@RefreshScope on a bean will enable the bean to be reconfigured (without restarting the app). In order to do that, send a request as this : *curl -d{} http://<computer-service-host>:<computer-service-port>/refresh. The bean annotated with @RefreshScope annotation will therefore be reconfigured after hitting refresh endpoint with such request.
 
 ## Step 3 : implement eureka service
 
 Eureka service will enable microservices to communicate with each other. Eureka service is an annuaire that tie each service id to each service host and port.
 
 * create eureka service (need eureka server and config client dependencies)
 * same configuration in bootstrap.properties
 * add @EnableDiscovery annotation, to tell computer-service to discover eureka service and register to it.
 * restart computer-service, and acknowledge that computer-service registered to eureka-service.
 
 
 ## Step 4 : implement edge service
 
 An edge service must be implemented to handle every incomming requests and dispatch them to relevant back-end microservices.
 Such edge service require the following dependencies : Eureka Discovery, Config client, ZuulProxy, Stream Rabbit, Hystrix.
 
 * create edge service as for instance : application-client
 * indicate the config server, the same way than the other services.
 * add @EnableZuulProxy on the spring boot class app.
 * get computers from the application-client at this url : http://localhost:9999/computer-service/computers (adapt if neeeded)
 
 Application client is then a simple micro-proxy.
 
 ## Step 5 : implement Gateway API
 
 At this, some we are going to create an enpoint that is going to serve us only computer names. Application-client will now become an API Gateway because it adds its own logic and is no longer used as simple microproxy.
 Rest Template enable to contact computer-service from our application-client. This url (http://computer-service/computers) will be used to contact computer-service. Computer-service in url will be resolved  by eureka service.
 
 ## Step 6 : Fallback method
 
 What happens if computer-service is no longer up. We don't want our user to get a big stacktrace. Our micro-services must be tolerant towards each other. 
 We are going to implement an error handling system :
 
 * set annotation @EnableCircuitBreaker on the spring boot class. (In application-client) 
 * on the method that returnes computer names, add @HystrixCommand(fallbackMethod="fallbackMethod") that indicates wich method must handle failure.
 * create fallback method that returns an empty list.
 
 ## Step 7 : Incoming datas
 
 We must answer the same problematic for incoming datas.
 To do that, we are going to use spring cloud stream that functions as Queues.
 
 * set @EnableBinding(Source.class) on application-client spring boot app class, source is just an interface to specify that output message is named output.
 * on the other side of the channel, set @EnableBinding(Sink.class) on computer-service spring boot app class. Sink is just an interface to specify that input message is named input.
 * channel configuration between front (application-client) and back (computer-service) is set in properties files.
 * create post request endpoint in application-client that get a channel and send the computerDto through this channel.
 * create "output" message endpoint in computer-service, that processes the computerDto.
 * try to send a computerDto through application client post computer endpoint.
 * If computer-service is not up, the message will be stored in RabbitMQ server and will be popped out as soon as computer-service is back up.
 
 ## Step 8 : Customize channel
 
 modify configuration in application-client as follows :
 
 spring.cloud.stream.bindings.computerInput.destination = computer-channel
 spring.cloud.stream.bindings.computerInput.group = computers-group
 spring.cloud.stream.bindings.computerInput.durableSubscription = true
 
 create ComputerSource interface et set EnableBindings(ComputerSource.class) in computer-service.
 
 in the same way adapt computer-service.
 adapt computer-service as follows :
 spring.cloud.stream.bindings.computerOutput.destination = computer-channel
 
 
 
 