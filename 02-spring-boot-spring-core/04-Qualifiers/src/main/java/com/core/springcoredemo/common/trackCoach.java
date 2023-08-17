package com.core.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class trackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Iam Track Coach";
    }
}
