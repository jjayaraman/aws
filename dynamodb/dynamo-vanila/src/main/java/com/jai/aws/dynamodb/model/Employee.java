package com.jai.aws.dynamodb.model;

import lombok.Data;

@Data
public class Employee {

    private String employeeName;
    private String phone;
    private Address homeAddress;
    private Address workAddress;
}

