 	package com.capstone.shopforhome.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.shopforhome.dto.UserDTO;
import com.capstone.shopforhome.entity.User;

import com.capstone.shopforhome.repository.UserRepository;

import com.capstone.shopforhome.vo.request.LoginForm;

/*
 * @Author:Dynaneshwari
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

@Service
public class UserServiceImp implements IUserService{
	@Autowired
	UserRepository userRepository;
	
	/*
	 * @Author:Dynaneshwari
	 * Modified Date:30-08-2022
	 * Description:This service method used for registering the user
	 * params : User DTO
	 * return type : string
	 */
	
	public boolean isLoggedIn=false;

	@Override
	public String registerUser(UserDTO userDTO) {
		
		if(userRepository.findByEmail(userDTO.getEmail())!=null) {
			return "User already exists";
		}
		else {
			//converting UserDTO to User(Entity)
			
			User u = new User();
			//u.setUserId(userDTO.getUserId());
			u.setName(userDTO.getName());
			u.setEmail(userDTO.getEmail());
			u.setAddress(userDTO.getAddress());
			u.setPassword(userDTO.getPassword());
			u.setContactNumber(userDTO.getContactNumber());
			u.setRole(userDTO.getRole());
			
			userRepository.save(u);
			return "Registered Successfully";
		}
	}
	
	/*
	 * @Author:Dynaneshwari
	 * Modified Date:30-08-2022
	 * Description:This service method used for authenticate the user 
	 * params : Login 
	 * return type : List<CartItem>
	 */

	@Override
	public User loginUser(LoginForm login) {
		String email = login.getEmail();
		System.out.println(email);
		User cu =userRepository.findByEmail(email);
		System.out.println(cu);
		if(cu!=null) {
			if(cu.getPassword().equals(login.getPassword())) {
				if(map.get(email)==null) {
					map.put(email, userRepository.getReferenceById(cu.getUserId()));
					System.out.println("map : "+map);
					System.out.println(userRepository.getReferenceById(cu.getUserId()));
				}
				this.isLoggedIn=true;	
				
				return cu;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}	
	}
	
	/*
	 * @Author:Dynaneshwari
	 * Modified Date:30-08-2022
	 * Description:This service method used for logging out the user
	 * params : string email 
	 * return type : string
	 */
	@Override
	public String logoutUser(String email) {

		if (map.get(email) != null) {
			map.remove(email);
			System.out.println("current loggedin users : "+map);
			this.isLoggedIn=false;
			return "Logout Success";
		} else {
			return "Please Login First";
		}

	}
	
	/*
	 * @Author:Dynaneshwari
	 * Modified Date:30-08-2022
	 * Description:This service method used for getting all users
	 * params : none
	 * return type : List<User>
	 */
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User updateUser(User user) {
		User oldUser = userRepository.getReferenceById(user.getUserId());
		oldUser.setName(user.getName());
		oldUser.setEmail(user.getEmail());
		oldUser.setAddress(user.getAddress());
		oldUser.setPassword(user.getPassword());
		oldUser.setRole(user.getRole());
		oldUser.setContactNumber(user.getContactNumber());
		return userRepository.save(oldUser);
	}

	/*
	 * @Author:Dynaneshwari
	 * Modified Date:30-08-2022
	 * Description:This service method used for removing the  user
	 * params :  Long userId
	 * return type : void
	 */
	@Override
	public void removeUser(Long userId) {
		
		User user =userRepository.getReferenceById(userId);
		
		
		
		userRepository.deleteById(userId);
		
	}
	
	/*
	 * @Author:Dynaneshwari
	 * Modified Date:30-08-2022
	 * Description:This service method used for getting userbyid
	 * params : Long userid 
	 * return type : User
	 */

	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		
		
		return userRepository.getReferenceById(userId);
	}
	
	/*
	 * @Author:Dynaneshwari
	 * Modified Date:30-08-2022
	 * Description:This service method used for getting the logged in status
	 * params : none
	 * return type : boolean
	 */
	public boolean getLoggedInStatus() {
		return this.isLoggedIn;
	}
	

}
