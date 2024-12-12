package com.ust.app.auth_service.api;

import com.ust.app.auth_service.model.UserModel;
import com.ust.app.auth_service.service.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserCrudService userCrudService;

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){
        return userCrudService.createUser(user);
    }

}
