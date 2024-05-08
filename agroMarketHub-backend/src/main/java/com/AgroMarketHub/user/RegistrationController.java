package com.AgroMarketHub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.AgroMarketHub.dto.AuthRequestDTO;
import com.AgroMarketHub.dto.AuthResponseDTO;
import com.AgroMarketHub.dto.ObjectResponseDTO;
import com.AgroMarketHub.entity.DocsEntity;
import com.AgroMarketHub.serviceImpl.JwtServiceImpl;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private JwtServiceImpl jwtServiceImpl;

	@PostMapping("/register")
	private UserEntity registerUser(@RequestBody UserDTO userDTO) throws Exception {
		return userService.createUserWithRole(userDTO);
	}

	@GetMapping("/getUsers")
	private List<ObjectResponseDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/auth")
    private AuthResponseDTO authenticateWithToke(@RequestBody AuthRequestDTO authDTO) throws Exception {
    	System.out.println("@@@ User "+ authDTO);
    	if(userService.getUserFromUsernameAndPass(authDTO) != null) {
    	    String token = jwtServiceImpl.generateToke(authDTO.getUserName());
    		
    		AuthResponseDTO authResponse = new AuthResponseDTO();
    		String userName = jwtServiceImpl.extractUsername(token);
    		authResponse.setToken(token);
    		authResponse.setUserName(userName);
    		authResponse.setId(userService.getUserFromToken(userName).getId());
        	return authResponse;
    	}
    	return null;
    }

	@PostMapping("/upload/{username}")
	private ResponseEntity<DocsEntity> uploadFiles(@RequestParam("file") MultipartFile file,
			@PathVariable String username) throws IOException {
		DocsEntity docs = userService.uploadFiles(file, username);
		if (docs != null) {
			return ResponseEntity.status(HttpStatus.OK).body(docs);
		}
		return (ResponseEntity<DocsEntity>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("/delete-docs/{id}")
	private String deleteDocs(@PathVariable long id) {
		userService.deleteDocs(id);
		return "successful";
	}
	
	private String getDocsUserPhoto(Long id) {
		return null;
	}
	
	@DeleteMapping("/deleteUserId/{id}")
	private void deleteUserById(@PathVariable long id) {
		userService.deleteUserById(id);
	}
	
	@DeleteMapping("/deleteAllUsers")
	private void deleteAllUsers() {
		userService.deleteAllUsers();
	}
	
	@PostMapping("/uploadUserImage/{userName}")
	private ObjectResponseDTO uploadUserImage(@RequestParam("image") MultipartFile file, @PathVariable String userName) throws IOException {
		return userService.uploadUserImage(file, userName);
	}
	
	@GetMapping("/fetchImagesById/{id}")
	private List<String> fetchUserImagesByUserId(@PathVariable long id){
		return userService.fetchUserImagesByUserId(id);
	}
}
