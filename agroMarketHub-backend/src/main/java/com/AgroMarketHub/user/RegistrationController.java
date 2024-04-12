package com.AgroMarketHub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    UserServiceImpl userService;
    @PostMapping("/register")
    private UserEntity registerUser(@RequestBody UserDTO userDTO) throws Exception {
        return userService.createUserWithRoles(userDTO.getUserName(), userDTO.getPassword(), userDTO.getRoles());
    }

    @GetMapping("/getUsers")
    private List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUserRole/{id}")
    private List<Object[]> getUserAndRole(@PathVariable Long id){
        return userService.getUserWithRole(id);
    }
}
