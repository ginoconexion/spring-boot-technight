package com.excilys.technight.dto;

/**
 * Created by pgm on 09/01/17.
 */
public class ComputerDto {
    private Long id;
    private String name;
    private String introduced;
    private String discontinued;
    private Long companyId;

    public ComputerDto(Long id, String name, String introduced, String discontinued, Long companyId) {
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

    public String getIntroduced() {
        return introduced;
    }

    public void setIntroduced(String introduced) {
        this.introduced = introduced;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class ComputerDtoBuilder {
        private Long id;
        private String name;
        private String introduced;
        private String discontinued;
        private Long companyId;

        public ComputerDtoBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ComputerDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ComputerDtoBuilder setIntroduced(String introduced) {
            this.introduced = introduced;
            return this;
        }

        public ComputerDtoBuilder setDiscontinued(String discontinued) {
            this.discontinued = discontinued;
            return this;
        }

        public ComputerDtoBuilder setCompanyId(Long companyId) {
            this.companyId = companyId;
            return this;
        }

        public ComputerDto createComputerDto() {
            return new ComputerDto(id, name, introduced, discontinued, companyId);
        }
    }
}
