package com.excilys.technight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableBinding(Sink.class)
@SpringBootApplication
public class ComputerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerServiceApplication.class, args);
	}
}
