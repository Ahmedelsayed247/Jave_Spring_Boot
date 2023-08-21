package com.core.springcoredemo.rest;

import com.core.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
    //define a private field for the dependence
   private Coach Mycoach ;
   private Coach AnotherCoach ;
   // define a constructor for dependence injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In Constructor " +getClass().getSimpleName());

        Mycoach = theCoach;
        AnotherCoach = theAnotherCoach ;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return Mycoach.getDailyWorkout() ;
    }

    @GetMapping("/check")
    public String check(){
        return  "The comparision of the two object " + (Mycoach == AnotherCoach);
    }
}
