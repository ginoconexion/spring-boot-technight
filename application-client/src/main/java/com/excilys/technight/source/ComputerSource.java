package com.excilys.technight.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by pgm on 18/01/17.
 */
public interface ComputerSource {
    String OUTPUT = "computerOutput";

    @Output("computerOutput")
    MessageChannel computerOutput();
}
