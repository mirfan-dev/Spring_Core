package com.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){

        String name="Md Irfan";
        List<String> userList=List.of("Zeeshan","Arman","Zaheer");
        model.addAttribute("name",name);
        model.addAttribute("userList",userList);
        return "home";
    }
}
