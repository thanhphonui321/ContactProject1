package com.thanhnd.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.thanhnd.config.SrpingRootConfig;
import com.thanhnd.dao.UserDAO;
import com.thanhnd.domain.User;

public class TestUserDAOFindByProp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SrpingRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
		List<User> list = userDAO.findByProperty("userId", "21");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getLoginName()+"\n");
		}
		System.out.println("done");
		context.close();
	}

}
