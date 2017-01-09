package com.excilys.technight.mapper;

import com.excilys.technight.dto.ComputerDto;
import com.excilys.technight.model.Computer;
import com.excilys.technight.utils.DateUtils;

import java.time.LocalDate;

/**
 * Created by pgm on 09/01/17.
 */
public class ComputerMapper {

    public static Computer fromDto(ComputerDto dto) {
        return dto != null ? new Computer.ComputerBuilder()
                .setId(dto.getId())
                .setName(dto.getName())
                .setIntroduced(LocalDate.parse(dto.getIntroduced(), DateUtils.getDateFormatter()))
                .setDiscontinued(LocalDate.parse(dto.getDiscontinued(), DateUtils.getDateFormatter()))
                .setCompanyId(dto.getCompanyId())
                .createComputer() : null;
    }

    public static ComputerDto toDto(Computer c) {
        return c != null ? new ComputerDto.ComputerDtoBuilder()
                .setId(c.getId())
                .setName(c.getName())
                .setIntroduced(c.getIntroduced().format(DateUtils.getDateFormatter()))
                .setDiscontinued(c.getDiscontinued().format(DateUtils.getDateFormatter()))
                .setCompanyId(c.getCompanyId())
                .createComputerDto() : null;
    }
}
