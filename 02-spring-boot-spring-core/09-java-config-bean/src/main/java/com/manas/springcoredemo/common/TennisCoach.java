package com.manas.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In constructor of " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }
}
