package com.capstone.shopforhome.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.shopforhome.dto.UserDTO;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.service.IUserService;
import com.capstone.shopforhome.service.UserServiceImp;
import com.capstone.shopforhome.vo.request.LoginForm;

/*
 * @Author:Amit
 * Modified Date:30-08-2022
 * Description:This Controller class is responsible for processing incoming REST API request.
 */


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	UserServiceImp userServiceImp;
	
	@PostMapping(value="register",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String registerUser(@RequestBody UserDTO userDTO) {
		
		return userService.registerUser(userDTO);
		
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody LoginForm login) {
		return userService.loginUser(login);
	}
	
	@GetMapping("/logout")
	public String logoutUser(@RequestParam long userId) {
		
		User user = userService.getUserById(userId);
		
		System.out.println("logout : "+IUserService.map.get(user.getEmail()));
		return userService.logoutUser(user.getEmail());
	}
	
	@GetMapping("/getusers")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		System.out.println("IN USER CONTROLLER");
		userService.removeUser(userId);
	}
	
	@GetMapping("/getLoggedInStatus")
	public boolean getLoggedInStatus() {
		return userServiceImp.isLoggedIn;
	}
	
	@GetMapping("/getuserbyid/{userId}")
	public User getsuerById(@PathVariable("userId") Long userId) {
		return this.userService.getUserById(userId);
	}
	
	
	@PutMapping("/updateuser/{userId}")
	public User updateUser(@RequestBody User user,@PathVariable("userId") Long userId ) {
		
		user.setUserId(userId);
		return userService.updateUser(user);
	}
	
	
	

}
