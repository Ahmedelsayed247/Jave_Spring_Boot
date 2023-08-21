package com.core.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class tennisCoach implements Coach{
    public tennisCoach(){
        System.out.println("In Constructor " +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Iam Baseball Coach";
    }
}
