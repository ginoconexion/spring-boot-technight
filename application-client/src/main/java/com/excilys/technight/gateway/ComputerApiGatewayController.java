package com.excilys.technight.gateway;

import com.excilys.technight.dto.ComputerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
