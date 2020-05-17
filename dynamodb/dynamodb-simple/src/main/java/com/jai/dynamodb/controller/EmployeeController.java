package com.jai.dynamodb.controller;

import com.jai.dynamodb.repository.EmployeeRepository;
import com.jai.dynamodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/tables")
    public ResponseEntity<?> findTables() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }
}
