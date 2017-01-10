package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dilanka on 12/23/16.
 */

@RestController
public class Controller {

    @RequestMapping("/")
    public String helloWorld() {
        return "HelloWorld";
    }
}
