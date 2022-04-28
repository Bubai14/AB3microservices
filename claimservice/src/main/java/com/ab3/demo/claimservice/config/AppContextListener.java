package com.ab3.demo.claimservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
//@Component
//@Profile("local")
public class AppContextListener implements ServletContextListener {

    @Autowired
    private SSHConnection sshConnection;

    public AppContextListener() {
        super();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //establish connection
        System.out.println("Context initialized ... !\n\n\n");
        try {
            //sshConnection = new SSHConnection();
            sshConnection.connect();
            System.out.println("\n\n\nSuccessfully established SSH connection!\n\n\n");
        } catch (Throwable e) {
            System.out.println("\n\n\nSSH connection failed!\n\n\n");
            e.printStackTrace();//error connecting SSH server
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Disconnect
        System.out.println("Context destroyed ... !\n\n\n");
        try {
            sshConnection.disconnect();//disconnect
            System.out.println("\n\n\nSuccessfully disconnected SSH connection!\n\n\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n\nError when disconnecting SSH connection!\n\n\n");
        }
   }
}
