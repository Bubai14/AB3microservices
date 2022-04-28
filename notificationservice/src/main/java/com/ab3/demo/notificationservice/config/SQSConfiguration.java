package com.ab3.demo.notificationservice.config;

import com.ab3.demo.notificationservice.dto.AwsSecrets;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfiguration {

    @Value("${cloud.aws.region.static}")
    private String region;

    @Autowired
    private AwsSecrets secrets;

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(getAmazonSQSAsync());
    }

    private AmazonSQSAsync getAmazonSQSAsync() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(secrets.getAccesskey(), secrets.getSecretkey());
        return AmazonSQSAsyncClientBuilder.
                standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}
