package com.ab3.demo.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwsSecrets {

    private String url;
    private String username;
    private String password;
    private String accesskey;
    private String secretkey;
}
