package com.AgroMarketHub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    UserServiceImpl userService;
    @PostMapping("/register")
    private UserEntity registerUser(@RequestBody UserDTO userDTO) throws Exception {
        return userService.registerUser(userDTO) ;
    }

    @PostMapping("/login")
    private String loginUser(@RequestBody UserDTO userDTO){
        return userService.loginUser(userDTO);
    }
}
