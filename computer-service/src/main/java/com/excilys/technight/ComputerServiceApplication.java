package com.excilys.technight;

import com.excilys.technight.endpoint.ComputerSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@EnableDiscoveryClient
@EnableBinding(ComputerSink.class)
@SpringBootApplication
public class ComputerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerServiceApplication.class, args);
	}
}
