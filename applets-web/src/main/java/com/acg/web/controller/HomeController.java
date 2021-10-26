package com.acg.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @ApiOperation(value = "home page")
    @RequestMapping(value = {"/","index","index.html"})
    public String hello(){
        return "hello springboot";
    }
}
