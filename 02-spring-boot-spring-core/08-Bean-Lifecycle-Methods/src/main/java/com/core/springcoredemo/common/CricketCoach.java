package com.core.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("In Constructor " +getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast";
    }
    //define our init method
    @PostConstruct
    public void doMyStartupStuff () {
        System.out.println( "In doMyStartupStuff " + getClass().getSimpleName() );
    }
    //define our destroy method
    @PreDestroy

    public void doMyCleanupStuff () {
        System.out.println( "In doMyCleanupStuff " + getClass().getSimpleName() );
    }

}
