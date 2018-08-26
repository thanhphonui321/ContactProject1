package com.thanhnd.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.thanhnd.config.SrpingRootConfig;
import com.thanhnd.dao.UserDAO;
import com.thanhnd.domain.User;

public class TestUserDAODelete {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SrpingRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
		userDAO.delete(12);
		System.out.println("deleted");
		context.close();
	}

}
