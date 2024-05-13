package com.AgroMarketHub.user;

import com.AgroMarketHub.classes.GenerateFileUrl;
import com.AgroMarketHub.dto.AuthRequestDTO;
import com.AgroMarketHub.dto.ObjectResponseDTO;
import com.AgroMarketHub.entity.DocsEntity;
import com.AgroMarketHub.entity.Role;
import com.AgroMarketHub.entity.UserImages;
import com.AgroMarketHub.repository.DocsRepository;
import com.AgroMarketHub.repository.RoleRepository;
import com.AgroMarketHub.repository.UserImagesRepository;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
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

	@Autowired
	UserImagesRepository userImagesRepository;

	@Transactional
	public UserEntity createUserWithRole(UserDTO userDTO) {
		UserEntity user = new UserEntity();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setUserName(userDTO.getUserName(userDTO.getFirstName(), userDTO.getLastName()));
		user.setPassword(passwordEncoder(userDTO.getPassword()));

		Set<Role> rolesToAdd = new HashSet<>();
		for (Role roles : userDTO.getRoles()) {
			Role role = roleRepository.findByName(roles.getName());

			if (role == null) {
				role = new Role();
				role.setName(roles.getName());
				role = roleRepository.save(role);
			}
			rolesToAdd.add(role);
		}
		user.setRoles(rolesToAdd);
		return userRepository.save(user);
	}

	public void deleteDocs(long id) {
		docsRepository.deleteById(id);
	}

	public List<ObjectResponseDTO> getAllUsers() {
		List<UserEntity> users = userRepository.findAll();
		List<ObjectResponseDTO> responseObj = new ArrayList<>();
		ObjectResponseDTO response = new ObjectResponseDTO();
		for (UserEntity user : users) {
			response.setId(user.getId());
			response.setFirstName(user.getFirstName());
			response.setLastName(user.getLastName());
			response.setEmail(user.getEmail());
			response.setUserName(user.getUserName());

			responseObj.add(response);
		}
		return responseObj;
	}

	public UserEntity findUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}

	public UserEntity getUserFromToken(String username) {
		UserEntity user = userRepository.findByUserName(username);
		return userRepository.findByUserName(username);
	}

	public String passwordEncoder(String password) {
		return DigestUtils.sha256Hex(password);
	}


	public UserEntity getUserFromUsernameAndPass(AuthRequestDTO auth) throws Exception {
		UserEntity currentUser = userRepository.findByUserName(auth.getUserName());
		if (currentUser != null) {
			if (!comparePassword(auth.getPassword(), currentUser)) {
				return null;
			}
		} else {
			throw new Exception("User not found");
		}

		return currentUser;
	}

	private boolean comparePassword(String password, UserEntity cur_user) {
		// TODO Auto-generated method stub
		String hashedPass = passwordEncoder(password);
		System.out.println("@@@ DB ----- " + cur_user.getPassword());
		System.out.println("@@@ Login ----- " + hashedPass);
		if (hashedPass.equals(cur_user.getPassword())) {
			return true;
		}
		return false;
	}

	public String getDocsUserPhoto(Long id) {

		return null;
	}

	public ObjectResponseDTO uploadFiles(MultipartFile file, String userName) throws IOException {
		String filePath = generateFileUrl.generateURL(file);
		DocsEntity doc = new DocsEntity();
		FileCopyUtils.copy(file.getBytes(), new File(filePath));
		System.out.println("@@@ username = " + userName);
		UserEntity user = getUserFromToken(userName);
		doc.setUrl(filePath);
		doc.setUser(getUserFromToken(userName));
		if(docsRepository.save(doc) != null){
			ObjectResponseDTO response = new ObjectResponseDTO();
			response.setFileURL(filePath);
			response.setUserName(userName);
			return response;
		}
		return null;
	}

	public ObjectResponseDTO uploadUserImage(MultipartFile file, String userName) throws IOException {
		String filePath = generateFileUrl.generateURL(file);
		UserImages userImages = new UserImages();
		FileCopyUtils.copy(file.getBytes(), new File(filePath));
		System.out.println("@@@ username = " + userName);
		UserEntity user = getUserFromToken(userName);
		userImages.setUrl(filePath);
		userImages.setUser(user);
		if(userImagesRepository.save(userImages) != null) {
			ObjectResponseDTO response = new ObjectResponseDTO();
			response.setFileURL(filePath);
			response.setUserName(userName);
			return response;
		};
		return null;
		
	}

	public List<String> fetchUserImagesByUserId(long id) {
		return userImagesRepository.getImageUrlByUserId(id);
	}
}
