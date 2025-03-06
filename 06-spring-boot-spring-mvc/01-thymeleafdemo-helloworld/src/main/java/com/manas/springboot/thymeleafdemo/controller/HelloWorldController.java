package com.manas.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    // need a controller to show initial html form
    // @RequestMapping("/showForm") // supports any request type Get or post
    @GetMapping("/showForm") //supports Get requests
    // @PostMapping("/showForm") //supports Post requests mapping
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller to read form data and add data to the model
    // @RequestMapping("/processFormVersionTwo")
    // @GetMapping("/processFormVersionTwo")
    @PostMapping("/processFormVersionTwo")
    public String upperCaseName(HttpServletRequest request, Model model) {
        // read req parameter from html form
        String theName = request.getParameter("studentName");

        // convert data to all caps
        theName = theName.toUpperCase();

        // add message to model
        model.addAttribute("message", theName);

        return "helloworld";
    }

    // using @requestParam for reading request params
    @RequestMapping("/processFormVersionThree")
    public String upperCaseName(@RequestParam("studentName") String theName,  Model model) {

        // convert data to all caps
        String result = "Hi from v3 " + theName.toUpperCase();

        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
