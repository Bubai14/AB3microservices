package com.ab3.demo.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.mail.simplemail.SimpleEmailServiceJavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    private SimpleEmailServiceJavaMailSender simpleEmailServiceJavaMailSender;

    public void sendMail(SimpleMailMessage simpleMailMessage){
        simpleEmailServiceJavaMailSender.send(simpleMailMessage);
        System.out.println("Mail sent");
    }
}
