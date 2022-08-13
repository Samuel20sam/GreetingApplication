package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    //UC1
    @GetMapping("/getMap")
    public String getMessage() {
        return "Hello World this is Samuel  from control layer";
    }

    @GetMapping("/getByParam")
    public String getByParam(@RequestParam String name) {
        return "Hello" + name;
    }

    @GetMapping("/getPath/{name}")
    public String getPath(@PathVariable String name) {
        return "Hello" + name;
    }

    //UC2
    @GetMapping("/getbyservice")
    public String getbyservice(){
        return greetingService.getmessage();
    }

    //UC3
    @GetMapping("/hello")
    public String sayPosting(@RequestParam(required = false) String firstName,
                             @RequestParam(required = false) String lastName) {
        if (lastName == null) lastName = "";
        else if (firstName == null) firstName = "";
        else if (firstName == null && lastName == null) {
            firstName = "";
            lastName = "";
        }
        return greetingService.sayHelloByName(firstName, lastName);
    }
}