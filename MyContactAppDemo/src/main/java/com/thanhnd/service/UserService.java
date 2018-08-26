package com.thanhnd.service;

import java.util.List;

import com.thanhnd.domain.User;
import com.thanhnd.exception.BlockedUserException;

public interface UserService {
	public static final int LOGIN_STATUS_ACTIVE = 1;
	public static final int LOGIN_STATUS_BLOCKED = 2;
	
	public static final int ROLE_ADMIN = 1;
	public static final int ROLE_USER = 2;
	/**
	 * This will allow to register an user
	 * @param u
	 */
	public void register(User u);
	
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return the User object if success, null if failed
	 * @throws BlockedUserException if user is blocked
	 */
	public User login(String username, String password) throws BlockedUserException;
	
	/**
	 * 
	 * @return all User which registered
	 */
	public List<User> viewAllUser();
	
	/**
	 * Change status for user 1 for active and 2 for block
	 * @param UserId
	 * @param status
	 */
	public void changeStatusUser (int UserId, int status);
        public boolean checkUsername (String username);
}
