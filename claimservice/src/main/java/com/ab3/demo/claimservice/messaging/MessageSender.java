package com.ab3.demo.claimservice.messaging;

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
        System.out.println("Sending message:"+ message);
        try{
            Message payload = MessageBuilder.withPayload(message)
                    .build();
            queueMessagingTemplate.send(endpoint, payload);
        } catch(Exception e){
            System.err.println("Exception sending message:"+e);
        }
        System.out.println("Message sent");
        return true;
    }
}
