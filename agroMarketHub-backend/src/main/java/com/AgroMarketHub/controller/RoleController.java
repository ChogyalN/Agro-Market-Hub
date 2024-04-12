package com.AgroMarketHub.controller;

import com.AgroMarketHub.entity.Role;
import com.AgroMarketHub.serviceImpl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/createRole")
    private Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
}
