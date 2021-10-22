package com.acg.web.controller;

import com.acg.entity.user.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    User user = new User();

    @RequestMapping(value = {"index","/","index.html"})
    public String home(){
        return "hello springboot";
    }
}
