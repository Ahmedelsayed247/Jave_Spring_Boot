package com.core.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("In Constructor " +getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast";
    }
}
