package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        // the html page to return
        return "home";
    }

    @GetMapping("/error")
    public String showError(){
        // the html page to return
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaders() {
        // the html page to return
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems() {
        // the html page to return
        return "systems";
    }


}
