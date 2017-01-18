package com.excilys.technight.endpoint;

import com.excilys.technight.dto.ComputerDto;
import com.excilys.technight.mapper.ComputerMapper;
import com.excilys.technight.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by pgm on 18/01/17.
 */
@MessageEndpoint
public class ComputerProcessor {

    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerProcessor(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @ServiceActivator(inputChannel = "computerInput")
    public void acceptComputer(ComputerDto dto) {
        this.computerRepository.save(ComputerMapper.fromDto(dto));
    }
}
