package com.first.firstprojectSpring.rest;

import org.springframework.beans.factory.annotation.Value;
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

    //inject properties for:coach.name and team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    //inject properties for:team info
    @GetMapping("/teaminfo")
    public String teamInfo(){
        return "Coach: " + coachName+" Team name: " +teamName ;
    }


}
