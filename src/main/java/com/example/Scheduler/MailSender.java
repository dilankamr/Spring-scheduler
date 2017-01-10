package com.example.Scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

/**
 * Created by dilanka on 1/2/17.
 */

@Configuration
@PropertySource("classpath:mail.properties")
public class MailSender {

    @Value("${mail.protocol}")
    private String protocol;
    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private int port;
    @Value("${mail.smtp.auth}")
    private boolean auth;

    @Bean
    JavaMailSender emailSender(){
        JavaMailSender javaMailSender = new JavaMailSender();
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", auth);
        javaMailSender.setJavaMailProperties(mailProperties);
        javaMailSender.setProtocol(protocol);
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        return javaMailSender;
    }
}
