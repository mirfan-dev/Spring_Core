package com.thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    @RequestMapping("/blog")
    public String blog(){
        System.out.println("This is blog section");
        return "blog";
    }
}
