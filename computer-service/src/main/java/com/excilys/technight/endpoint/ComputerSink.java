package com.excilys.technight.endpoint;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by pgm on 18/01/17.
 */
public interface ComputerSink {
    String INPUT = "computerInput";

    @Input("computerInput")
    SubscribableChannel computerInput();
}
