package com.jai.dynamodb.repository;

import com.jai.dynamodb.entity.Employee;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
public interface EmployeeRepository extends CrudRepository<Employee,String> {

}
