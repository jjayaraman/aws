package com.jai.aws.dynamodb.repository;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.awscore.client.builder.AwsClientBuilder;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

import java.util.HashMap;
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


    public PutItemResponse create() {

        Map<String, AttributeValue> item = new HashMap<>();
        item.put("employee_id", AttributeValue.builder().s(UUID.randomUUID().toString()).build());
        item.put("employeeName", AttributeValue.builder().s("jay").build());

        PutItemRequest putItemRequest = PutItemRequest.builder()
                .tableName(TABLE)
                .item(item)
                .build();

        PutItemResponse putItemResponse = dynamoDbClient.putItem(putItemRequest);
        return putItemResponse;
    }


}
