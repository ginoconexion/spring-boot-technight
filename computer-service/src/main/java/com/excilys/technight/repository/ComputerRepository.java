package com.excilys.technight.repository;

import com.excilys.technight.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pgm on 21/12/16.
 */

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
