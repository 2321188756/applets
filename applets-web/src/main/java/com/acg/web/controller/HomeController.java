package com.acg.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = {"/","index","index.html"})
    public String hello(){
        return "hello springboot";
    }
}
