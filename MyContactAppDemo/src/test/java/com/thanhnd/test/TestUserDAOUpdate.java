package com.thanhnd.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.thanhnd.config.SrpingRootConfig;
import com.thanhnd.dao.UserDAO;
import com.thanhnd.domain.User;

public class TestUserDAOUpdate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SrpingRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
		User u = new User();
		u.setUserId(18);
		u.setName("Thanh");
		u.setLoginName("longcc");
		u.setPassword("123");
		userDAO.update(u);;
		System.out.println("updated");
		context.close();
	}
}
