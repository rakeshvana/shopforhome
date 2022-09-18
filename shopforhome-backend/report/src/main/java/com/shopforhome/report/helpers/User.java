package com.shopforhome.report.helpers;

/*
 * @Author:Chaitanya
 * Modified Date:30-08-2022
 * Description:This Entity class is used to create table in database
 * 
 */

public class User {
	private long userId;
	private String email;
	private String name;
	private String address;
	private long contactNumber;
	private String password;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long userId, String email, String name, String address, long contactNumber, String password,
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
	private String role;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
}
