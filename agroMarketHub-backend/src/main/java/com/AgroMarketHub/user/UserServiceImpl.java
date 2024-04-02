package com.AgroMarketHub.user;

import com.AgroMarketHub.dto.AuthRequestDTO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;
    public UserEntity registerUser(UserDTO userDTO){
        UserEntity user = null;
        try{
            user = new UserEntity(
                    userDTO.getUserName(),
                    passwordEncoder(userDTO.getPassword())
            );
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public String loginUser(UserDTO userDTO){
        UserEntity loggedInUser = userRepository.findByUserName(userDTO.getUserName());
        System.out.println(loggedInUser);
        if(loggedInUser == null){
            return "The user doesnot exist";
        } else if (comparePassword(userDTO.getPassword(), loggedInUser.getPassword())) {
            System.out.println("password matched");
            return "Credential matched";
        }
        return "Credential did not match";
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
