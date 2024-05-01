package com.AgroMarketHub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.AgroMarketHub.entity.DocsEntity;

import java.io.IOException;
import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    UserServiceImpl userService;
    
    
    @PostMapping("/register")
    private UserEntity registerUser(@RequestBody UserDTO userDTO) throws Exception {
        return userService.createUserWithRole(userDTO);
    }

    @GetMapping("/getUsers")
    private List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/upload/{username}")
    private ResponseEntity<DocsEntity> uploadFiles(@RequestParam("file") MultipartFile file, @PathVariable String username) throws IOException {
    	DocsEntity docs = userService.uploadFiles(file, username);
    	if(docs != null) {
        	return ResponseEntity.status(HttpStatus.OK).body(docs);
    	}
    	return (ResponseEntity<DocsEntity>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
