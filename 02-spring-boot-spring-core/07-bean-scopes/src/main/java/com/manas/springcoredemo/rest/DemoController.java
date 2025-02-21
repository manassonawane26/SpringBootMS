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
    private Coach anotherCoach;

    // define a constructor for  Dependency Injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In constructor of " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("dailyworkout")
    public String getDailyworkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach: " + (myCoach==anotherCoach) ;
    }
}
