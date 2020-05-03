package com.jai.dynamodb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getAllEmplouee() {
        System.out.println("xx :: " +employeeRepository.findAll());
    }
}