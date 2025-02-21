package com.manas.springcoredemo.rest;

import com.manas.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define private field for dependency Injection
    private Coach myCoach;

    // define a constructor for  Dependency Injection
    @Autowired
    // public DemoController(@Qualifier("swimCoach") Coach myCoach) {
    public DemoController(@Qualifier("aquatic") Coach myCoach) {
        System.out.println("In constructor of " + getClass().getSimpleName());
        this.myCoach = myCoach;
    }

    @GetMapping("dailyworkout")
    public String getDailyworkout(){
        return myCoach.getDailyWorkout();
    }


}
