package com.first.firstprojectSpring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunctionRestController {
    // expose "/" that return "HelloWorld"
    @GetMapping("/")
    public String sayHello(){
        return "Hello world !" ;
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is lucky day!";
    }

}
