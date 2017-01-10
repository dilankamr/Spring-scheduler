package com.example.Scheduler;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by dilanka on 1/1/17.
 */
@Component
public class Scheduler {

    @Autowired
    DbChecker dbChecker;

    @Autowired
    EmailService emailSender;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {

        System.out.println(dbChecker.getDbUpdates());

        JSONObject contentObject = dbChecker.getDbUpdates();

        String content = "";
        emailSender.sendMail(content.toString());
    }
}
