package com.excilys.technight.gateway;

import com.excilys.technight.dto.ComputerDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pgm on 16/01/17.
 */
@RestController
@RequestMapping(value = "/computers")
public class ComputerApiGatewayController {

    private final RestTemplate restTemplate;

    @Autowired
    public ComputerApiGatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Collection<String> getNamesError() {
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "getNamesError")
    @RequestMapping(method = RequestMethod.GET, value = "/names")
    public Collection<String> getNames() {
        return this.restTemplate.exchange("http://computer-service/computers", HttpMethod.GET, null, new ParameterizedTypeReference<List<ComputerDto>>() {
        })
        .getBody()
        .stream()
        .peek(System.out::println)
        .map(c -> c.getName())
        .collect(Collectors.toList());
    }
}
