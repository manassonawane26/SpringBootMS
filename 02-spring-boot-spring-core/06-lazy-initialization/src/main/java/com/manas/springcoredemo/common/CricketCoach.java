package com.manas.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor of " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 minutes.";
    }
}
