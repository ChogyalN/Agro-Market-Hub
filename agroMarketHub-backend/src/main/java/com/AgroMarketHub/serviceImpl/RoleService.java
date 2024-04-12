package com.AgroMarketHub.serviceImpl;

import com.AgroMarketHub.entity.Role;
import com.AgroMarketHub.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id){
        return roleRepository.findById(id).orElse(null);
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public Role updateRole(Role updateRole, Long id){
        updateRole.setId(id);
        return roleRepository.save(updateRole);
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }
}
