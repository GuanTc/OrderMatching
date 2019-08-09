package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {
    @RequestMapping("/boot/index")
    public String index(Model model){
       model.addAttribute("msg","Spring boo集成JSP");
       return "index";
    }
}
