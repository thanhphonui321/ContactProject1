package com.thanhnd.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.thanhnd.config.SrpingRootConfig;
import com.thanhnd.dao.UserDAO;
import com.thanhnd.domain.User;

public class TestUserDAOFindById {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SrpingRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
		User u = userDAO.findById(13);
		System.out.println(u.getName());
		System.out.println(u.getLoginName());
		context.close();
	}
}
