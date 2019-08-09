package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {

    //just return the result, we can see the json result in web browser. Don't need JSP
    @RequestMapping("/boot/index")
    public String index(Model model){
       return "index";
    }
}
