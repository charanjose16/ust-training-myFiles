package com.ust.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

//@Controller
public class AppController {

    @GetMapping("/hello")
    public ModelAndView sayHello(@RequestParam("username") String username){
        String time= LocalTime.now().toString();
        ModelAndView mv=new ModelAndView("hello.jsp");
        mv.addObject("time",time);
        mv.addObject("username",username);
        return mv;
    }

//    @GetMapping("/index")
//    public  String sayName(){
//        return "index.jsp";
//    }

}
