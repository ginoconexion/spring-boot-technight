package com.excilys.technight.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pgm on 13/01/17.
 */
@RestController
@RequestMapping(value = "/message")
@RefreshScope
public class MessageController {

    @Value("${message}")
    private String message;

    @RequestMapping(method = RequestMethod.GET)
    public String getMessage() {
        return message;
    }
}
