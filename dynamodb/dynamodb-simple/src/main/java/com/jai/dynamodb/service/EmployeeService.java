package com.jai.dynamodb.service;

import com.jai.dynamodb.entity.Employee;
import com.jai.dynamodb.repository.EmployeeRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return IterableUtils.toList(employeeRepository.findAll());
    }
}
