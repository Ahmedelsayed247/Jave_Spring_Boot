package com.core.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class tennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Iam Baseball Coach";
    }
}
