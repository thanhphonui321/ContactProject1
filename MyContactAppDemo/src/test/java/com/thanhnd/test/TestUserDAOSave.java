package com.thanhnd.test;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.thanhnd.config.SpringWebConfig;
import com.thanhnd.config.SrpingRootConfig;
import com.thanhnd.dao.UserDAO;
import com.thanhnd.dao.UserDAOImpl;
import com.thanhnd.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SrpingRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
		User u = new User();
		u.setName("Thanh");
		u.setLoginName("thanhphonui12");
		u.setPassword("123");
		userDAO.save(u);
		System.out.println("saved");
		context.close();
	}

}
