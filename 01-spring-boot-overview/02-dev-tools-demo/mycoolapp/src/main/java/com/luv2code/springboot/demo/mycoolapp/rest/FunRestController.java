package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/merhaba")
    public String sayMerhaba(){
        return "Merhaba Dunya!";
    }

    @GetMapping("/greeting")
    public String messageGreeting(){
        return "It's good to see you back!";
    }

}
