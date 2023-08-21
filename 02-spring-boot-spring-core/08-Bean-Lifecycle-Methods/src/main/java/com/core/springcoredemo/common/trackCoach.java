package com.core.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class trackCoach implements Coach{
    public trackCoach(){
        System.out.println("In Constructor " +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Iam Track Coach";
    }
}
