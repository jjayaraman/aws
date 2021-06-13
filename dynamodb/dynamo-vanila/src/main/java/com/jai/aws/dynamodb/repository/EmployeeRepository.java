package com.jai.aws.dynamodb.repository;

import com.jai.aws.dynamodb.model.Address;
import com.jai.aws.dynamodb.model.Employee;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EmployeeRepository {

    private DynamoDbClient dynamoDbClient = null;

    private static final String TABLE = "employee";

    public EmployeeRepository() {

        dynamoDbClient = DynamoDbClient.builder()
                .credentialsProvider(ProfileCredentialsProvider
                        .builder()
                        .profileName("default")
                        .build())
                .build();
    }


    public List<String> getAllTables() {
        return dynamoDbClient.listTables().tableNames();
    }

    public ScanResponse readAll() {
        ScanRequest scanRequest = ScanRequest.builder()
                .tableName(TABLE)
                .build();
        return dynamoDbClient.scan(scanRequest);
    }


    public PutItemResponse create(final Employee employee) {

        Map<String, AttributeValue> item = new HashMap<>();
        item.put("employee_id", AttributeValue.builder().s(UUID.randomUUID().toString()).build());
        item.put("employeeName", AttributeValue.builder().s(employee.getEmployeeName()).build());
        item.put("phone", AttributeValue.builder().n(employee.getPhone()).build());

        Address homeAddress = employee.getHomeAddress();
        if (homeAddress != null) {

            item.put("homeAddress",
                    AttributeValue.builder()
                            .l(
                                    AttributeValue.builder().s(homeAddress.getFirstLine()).build(),
                                    AttributeValue.builder().s(homeAddress.getSecondLine()).build(),
                                    AttributeValue.builder().s(homeAddress.getCity()).build(),
                                    AttributeValue.builder().s(homeAddress.getCountry()).build()
                            )
                            .build());
        }

        Address workAddress = employee.getWorkAddress();
        if (workAddress != null) {
            item.put("workAddress",
                    AttributeValue.builder()
                            .l(
                                    AttributeValue.builder().s(workAddress.getFirstLine()).build(),
                                    AttributeValue.builder().s(workAddress.getSecondLine()).build(),
                                    AttributeValue.builder().s(workAddress.getCity()).build(),
                                    AttributeValue.builder().s(workAddress.getCountry()).build()
                            )
                            .build());
        }

        PutItemRequest putItemRequest = PutItemRequest.builder()
                .tableName(TABLE)
                .item(item)
                .build();

        PutItemResponse putItemResponse = dynamoDbClient.putItem(putItemRequest);
        return putItemResponse;
    }


    public DeleteItemResponse delete(String employeeId) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("employee_id", AttributeValue.builder().s(employeeId).build());

        DeleteItemRequest deleteItemRequest = DeleteItemRequest
                .builder()
                .key(item)
                .tableName(TABLE)
                .build();
        return dynamoDbClient.deleteItem(deleteItemRequest);
    }
}

