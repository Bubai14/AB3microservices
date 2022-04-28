package com.ab3.demo.notificationservice.messaging;

import com.ab3.demo.notificationservice.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageReceiver {

    @Value("${app.mail.from}")
    private String mailFrom;
    @Value("${app.mail.to}")
    private String mailTo;
    @Autowired
    private MailService mailService;

    @SqsListener(value = "ab3-claims-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveClaimMessages(String message) {
        log.debug("Message Received from ab3-claims-queue:"+ message);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailFrom);
        mailMessage.setTo(mailTo);
        mailMessage.setSubject("Claim Request");
        mailMessage.setText(message);
        mailService.sendMail(mailMessage);
    }

    @SqsListener(value = "ab3-policy-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receivePolicyMessages(String message) {
        log.debug("Message Received from ab3-policy-queue:"+ message);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailFrom);
        mailMessage.setTo(mailTo);
        mailMessage.setSubject("Policy Purchase");
        mailMessage.setText(message);
        mailService.sendMail(mailMessage);
    }
}
