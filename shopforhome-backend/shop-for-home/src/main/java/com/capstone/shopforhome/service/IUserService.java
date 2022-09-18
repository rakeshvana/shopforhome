package com.capstone.shopforhome.service;

import java.util.HashMap;
import java.util.List;

import com.capstone.shopforhome.dto.UserDTO;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.vo.request.LoginForm;

/*
 * @Author:Amit
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

public interface IUserService {
	public static HashMap<String, User> map = new HashMap<>();
	
	public String registerUser(UserDTO userDTO);
	public User loginUser(LoginForm login);
	public String logoutUser(String email);
	void removeUser(Long userId);
	User updateUser(User user);
	List<User> getAllUsers();
	User getUserById(long userId);
}
