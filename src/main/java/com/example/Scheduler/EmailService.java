package com.example.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * Created by dilanka on 1/1/17.
 */

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Service
@PropertySource("classpath:mail.properties")
public class EmailService {

    @Bean
    SimpleMailMessage simpleMailMessage(){
        return new SimpleMailMessage();
    }

    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage templateMessage;

    @Value("${mail.from}")
    private String from;
    @Value("${mail.subject}")
    private String subject;
    @Value("${mail.precontent}")
    private String precontent;
    @Value("${mail.postcontent}")
    private String postcontent;

    public void sendMail(String content) {

        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo("dilanka.rathnayake@shipxpress.com");
        msg.setFrom("dilankamr@gmail.com");
        msg.setSubject(subject);
        msg.setText(precontent+" "+postcontent);

        try{
            this.mailSender.send(msg);
            System.out.println(this.mailSender);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
