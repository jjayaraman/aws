package com.jai.dynamodb.service;

import com.jai.dynamodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void getEmployees() {
        employeeRepository.findAll().forEach(System.out::println);
    }
}
