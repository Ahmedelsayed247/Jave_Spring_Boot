package com.core.springcoredemo.rest;

import com.core.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
    //define a private field for the dependence
   private Coach Mycoach ;

   // define a constructor for dependence injection
    @Autowired
    public DemoController(Coach theCoach){
       Mycoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return Mycoach.getDailyWorkout() ;
    }
}
