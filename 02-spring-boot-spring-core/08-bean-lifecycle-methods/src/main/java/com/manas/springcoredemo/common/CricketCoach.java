package com.manas.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor of " + getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("Inside doMyStartupStuff: " + getClass().getSimpleName());
    }
    // define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("Inside doMyCleanupStuff: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 minutes.";
    }
}
