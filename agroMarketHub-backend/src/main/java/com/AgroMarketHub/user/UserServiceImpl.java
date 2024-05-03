package com.AgroMarketHub.user;

import com.AgroMarketHub.classes.GenerateFileUrl;
import com.AgroMarketHub.dto.AuthRequestDTO;
import com.AgroMarketHub.entity.DocsEntity;
import com.AgroMarketHub.entity.Role;
import com.AgroMarketHub.repository.DocsRepository;
import com.AgroMarketHub.repository.RoleRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Path;
@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    GenerateFileUrl generateFileUrl;
    
    @Autowired
    DocsRepository docsRepository;

    
    @Transactional
    public UserEntity createUserWithRole(UserDTO userDTO) {
    	UserEntity user = new UserEntity();
    	user.setFirstName(userDTO.getFirstName());
    	user.setLastName(userDTO.getLastName());
    	user.setEmail(userDTO.getEmail());
    	user.setUserName(userDTO.getUserName(userDTO.getFirstName(), userDTO.getLastName()));
    	user.setPassword(passwordEncoder(userDTO.getPassword()));
    	
    	if(userDTO.getRoles() != null) {
        	Set<Role> roles = new HashSet<Role>();

    		for(String roleName : userDTO.getRoles()) {
        		Role role = roleRepository.findByName(userDTO.getUserName(userDTO.getFirstName(), userDTO.getLastName()));
        		if(role != null) {
        			roles.add(role);
        		}
        	}
        	user.setRoles(roles);
    	}
    
    	return userRepository.save(user);
    }
    
    public DocsEntity uploadFiles(MultipartFile file, String userName) throws IOException {
    	String filePath = generateFileUrl.generateURL(file);
    	DocsEntity doc = new DocsEntity();
		FileCopyUtils.copy(file.getBytes(), new File(filePath));
		System.out.println("@@@ username = "+ userName);
		UserEntity user = getUserFromToken(userName);
    	doc.setUrl(filePath);
    	doc.setUser(getUserFromToken(userName));
    	return docsRepository.save(doc);
    }
    
    public void deleteDocs(long id) {
    	docsRepository.deleteById(id);
    }
    
    public List<UserEntity> getAllUsers(){
    	return userRepository.findAll();
    }
    

    public UserEntity findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity getUserFromToken(String username){
    	UserEntity user = userRepository.findByUserName(username);
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
    
    public UserEntity getUserFromUsernameAndPass(AuthRequestDTO auth) throws Exception {
    	UserEntity currentUser = userRepository.findByUserName(auth.getUserName());
    	if(currentUser != null) {
    		if(!comparePassword(auth.getPassword(), currentUser)) {
        		return null;
        	}
    	}else {
    		throw new Exception("User not found");
    	}
    	
    	return currentUser;
    }

	private boolean comparePassword(String password, UserEntity cur_user) {
		// TODO Auto-generated method stub
		String hashedPass = passwordEncoder(password);
		System.out.println("@@@ DB ----- "+ cur_user.getPassword());
		System.out.println("@@@ Login ----- "+ hashedPass);
		if(hashedPass.equals(cur_user.getPassword())) {
			return true;
		}
		return false;
	}
}
