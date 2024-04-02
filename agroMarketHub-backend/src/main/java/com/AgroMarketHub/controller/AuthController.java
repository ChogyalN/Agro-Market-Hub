package com.AgroMarketHub.controller;

import com.AgroMarketHub.dto.AuthRequestDTO;
import com.AgroMarketHub.user.UserDTO;
import com.AgroMarketHub.user.UserRepository;
import com.AgroMarketHub.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserServiceImpl userService;

    private String authenticate(@RequestBody AuthRequestDTO authRequestDTO){
        return null;
    }


}
