package com.first.firstprojectSpring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunctionRestController {
    // expose "/" that return "HelloWorld"
    @GetMapping("/")
    public String sayHello(){
        return "Hello world !" ;
    }
}
