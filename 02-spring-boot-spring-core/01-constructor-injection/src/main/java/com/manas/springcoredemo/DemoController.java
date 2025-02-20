package com.manas.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define private field for dependency Injection
    private Coach myCoach;

    // define a constructor for Dependency Injection
    @Autowired
    public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("dailyworkout")
    public String getDailyworkout(){
        return myCoach.getDailyWorkout();
    }
}
