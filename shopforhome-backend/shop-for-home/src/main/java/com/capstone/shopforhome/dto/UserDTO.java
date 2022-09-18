package com.capstone.shopforhome.dto;

/*
 * @Author:Amit
 * Modified Date:30-08-2022
 * Description:This DTO class is responsible for transferring data to controller to service.
 */



public class UserDTO {
	private Long userId;
	private String email;
	private String name;
	private String address;
	private Long contactNumber;
	private String password;
	private String role;
	
	public UserDTO() {}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserDTO(Long userId, String email, String name, String address, long contactNumber, String password,
			String role) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.password = password;
		this.role = role;
	}
	
	
	
}
