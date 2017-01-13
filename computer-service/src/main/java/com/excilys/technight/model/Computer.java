package com.excilys.technight.model;


import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by pgm on 21/12/16.
 */

@Entity
public class Computer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate introduced;

    @Column(nullable = false)
    private LocalDate discontinued;

    @Column(nullable = false)
    private Long companyId;

    public Computer() {
    }

    public Computer(Long id, String name, LocalDate introduced, LocalDate discontinued, Long companyId) {
        this.id = id;
        this.name = name;
        this.introduced = introduced;
        this.discontinued = discontinued;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getIntroduced() {
        return introduced;
    }

    public void setIntroduced(LocalDate introduced) {
        this.introduced = introduced;
    }

    public LocalDate getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(LocalDate discontinued) {
        this.discontinued = discontinued;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public static class ComputerBuilder {
        private Long id;
        private String name;
        private LocalDate introduced;
        private LocalDate discontinued;
        private Long companyId;

        public ComputerBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ComputerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ComputerBuilder setIntroduced(LocalDate introduced) {
            this.introduced = introduced;
            return this;
        }

        public ComputerBuilder setDiscontinued(LocalDate discontinued) {
            this.discontinued = discontinued;
            return this;
        }

        public ComputerBuilder setCompanyId(Long companyId) {
            this.companyId = companyId;
            return this;
        }

        public Computer createComputer() {
            return new Computer(id, name, introduced, discontinued, companyId);
        }
    }
}
