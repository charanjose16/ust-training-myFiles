package com.ust.app.auth_service.api;


import com.ust.app.auth_service.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/app")
public class AppController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/hello/admin")
    public String sayHelloAdmin(){
        return "Hello Admin";
    }

    @GetMapping("/hello/user")
    public String sayHelloUser(){
        return "Hello User";
    }


}
