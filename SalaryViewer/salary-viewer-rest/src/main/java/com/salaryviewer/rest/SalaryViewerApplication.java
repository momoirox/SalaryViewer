package com.salaryviewer.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.salaryviewer", "com.salaryviewer.core.repositories", "com.salaryviewer.core.services"})
public class SalaryViewerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalaryViewerApplication.class, args);
    }
}
