package com.ll.chap03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("a")
    @ResponseBody
    public String hello(){
        System.out.println("Hello!");
        return "Hello!";
    }
    @GetMapping("b")
    @ResponseBody
    public String hello2(){
        System.out.println("Hello2!");
        return "Hello2!";
    }
}
