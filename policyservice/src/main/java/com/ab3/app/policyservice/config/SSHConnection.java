package com.ab3.app.policyservice.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "local")
public class SSHConnection {

    private String PRIVATE_KEY = "/Users/bubaibal/Documents/secrets/EMR-kp.pem";
    private String USER = "ec2-user";
    private String HOST = "ec2-15-206-157-219.ap-south-1.compute.amazonaws.com";
    private Integer PORT = 22;
    private String REMOTE_SERVER = "ab3-mysql-cluster.cluster-cfvtvokvhvu2.ap-south-1.rds.amazonaws.com";
    private Integer REMOTE_PORT = 3306;
    private Session session = null;

    public void connect() throws JSchException {
        JSch jSch = new JSch();
        jSch.addIdentity(PRIVATE_KEY);

        session = jSch.getSession(USER, HOST, PORT);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        session.setPortForwardingL(3307, REMOTE_SERVER, REMOTE_PORT);
    }

    public void disconnect() {
        this.session.disconnect();
    }
}
