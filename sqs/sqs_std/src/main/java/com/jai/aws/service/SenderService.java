package com.jai.aws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    private final String QUEUE = "https://sqs.us-east-1.amazonaws.com/713754826514/jay-std-q";

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;


    public void sendMessage(String message) {
        queueMessagingTemplate.convertAndSend(QUEUE,MessageBuilder.withPayload("Hello world").build());
    }
}
