package com.demo.controller;
import com.demo.service.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MybatisController {

    @Autowired
    private StudentServiceImpl studentService;
    @RequestMapping("/boot/test")
    @ResponseBody
    public  Object demo(){
        System.out.println("aa");
        return studentService.findAll();
    }

}
