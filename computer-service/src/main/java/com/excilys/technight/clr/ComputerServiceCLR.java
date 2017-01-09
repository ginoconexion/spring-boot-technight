package com.excilys.technight.clr;

import com.excilys.technight.model.Computer;
import com.excilys.technight.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by pgm on 21/12/16.
 */
@Component
public class ComputerServiceCLR implements CommandLineRunner {

    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerServiceCLR(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }


    @Override
    public void run(String... strings) throws Exception {

        Computer c1 = new Computer.ComputerBuilder().setId(1L).setIntroduced(LocalDate.of(1992, 3, 29)).setDiscontinued(LocalDate.of(2016, 3, 29)).setName("Computer 1").setCompanyId(1L).createComputer();
        Computer c2 = new Computer.ComputerBuilder().setId(2L).setIntroduced(LocalDate.of(1992, 3, 29)).setDiscontinued(LocalDate.of(2016, 3, 29)).setName("Computer 2").setCompanyId(1L).createComputer();
        Computer c3 = new Computer.ComputerBuilder().setId(3L).setIntroduced(LocalDate.of(1992, 3, 29)).setDiscontinued(LocalDate.of(2016, 3, 29)).setName("Computer 3").setCompanyId(2L).createComputer();
        Computer c4 = new Computer.ComputerBuilder().setId(4L).setIntroduced(LocalDate.of(1992, 3, 29)).setDiscontinued(LocalDate.of(2016, 3, 29)).setName("Computer 4").setCompanyId(2L).createComputer();

        System.out.println("c4 = " + c4);
        System.out.println("Insertion des computers dans la base");
        Stream.of(c1, c2, c3, c4).forEach(c -> computerRepository.save(c));

        computerRepository.findAll().forEach(System.out::println);
    }
}
