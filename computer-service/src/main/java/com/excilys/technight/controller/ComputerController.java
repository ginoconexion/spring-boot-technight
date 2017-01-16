package com.excilys.technight.controller;

import com.excilys.technight.dto.ComputerDto;
import com.excilys.technight.mapper.ComputerMapper;
import com.excilys.technight.model.Computer;
import com.excilys.technight.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pgm on 21/12/16.
 */

@RestController
@RequestMapping(value = "/computers")
public class ComputerController {

    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerController(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<ComputerDto> getAll() {
        return computerRepository.findAll().stream().map(ComputerMapper::toDto).collect(Collectors.toList());
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ComputerDto getById(@PathVariable Long id) {
        return ComputerMapper.toDto(computerRepository.findOne(id));
    }
}