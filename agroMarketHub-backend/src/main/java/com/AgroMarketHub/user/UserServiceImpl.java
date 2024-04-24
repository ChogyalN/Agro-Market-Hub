package com.AgroMarketHub.user;

import com.AgroMarketHub.dto.AuthRequestDTO;
import com.AgroMarketHub.entity.Role;
import com.AgroMarketHub.repository.RoleRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public UserEntity createUserWithRoles(String username, String password, Set<String> roleNames){
        UserEntity user = new UserEntity();
        user.setUserName(username);
        user.setPassword(passwordEncoder(password));

        Set<Role> roles = new HashSet<Role>();
        for(String roleName : roleNames){
            Role role = roleRepository.findByName(roleName);
            if(role != null){
                roles.add(role);
            }
        }
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

//    public List<Object[]> getUserWithRole(Long id){
//        return userRepository.findUserAndRoleByUsername(findUserById(id).getUserName());
//    }

    public UserEntity findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity getUserFromToken(String username){
        return userRepository.findByUserName(username);
    }

    public String passwordEncoder(String password){
        return DigestUtils.sha256Hex(password);
    }

    private boolean comparePassword(String password, String fetchedPassword){
        String hashedPasswordEntered = passwordEncoder(password);
        System.out.println(hashedPasswordEntered);
        System.out.println(fetchedPassword);
        return hashedPasswordEntered.equals(fetchedPassword);
    }
}
