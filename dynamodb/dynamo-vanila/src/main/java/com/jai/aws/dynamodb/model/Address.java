package com.jai.aws.dynamodb.model;

import lombok.Data;

@Data
public class Address {
    private String firstLine;
    private String secondLine;
    private String city;
    private String country;
}
