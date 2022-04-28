package com.ab3.demo.claimservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@Data
//@EnableConfigurationProperties
//@ConfigurationProperties(prefix = "app.ssh")
public class SSHConfig {
    private String host;
    private Integer port;
    private String user;
    private String privatekey;
    private String remoteserver;
    private Integer remoteport;
}