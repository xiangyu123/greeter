package edu.franklin.greeter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping(path="/")
    public String sayHello() {
        return "hi there!";
    }
}
