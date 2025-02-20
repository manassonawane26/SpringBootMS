package com.manas.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // inject properties for coach.name, team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose endpoint that returns team info
    @GetMapping("teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + " Team: " + teamName;
    }

    // expose "/" that returns hello world!
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    //Expose a new New Endpoint for "workout"
    @GetMapping("workout")
    public String getDailyWorkout(){
        return "Run Hard 5 KM";
    }

    //Expose a new New Endpoint for "fortune"
    @GetMapping("fortune")
    public String getDailyFortune(){
        return "Today is your Lucky Day!";
    }
}
