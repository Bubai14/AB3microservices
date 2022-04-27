package com.ab3.app.policyservice.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public boolean send(String message) {
        Message payload = MessageBuilder.withPayload(message)
                .build();
        queueMessagingTemplate.send(endpoint, payload);
        return true;
    }
}
