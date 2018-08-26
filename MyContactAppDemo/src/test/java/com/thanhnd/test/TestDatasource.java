package com.thanhnd.test;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.thanhnd.config.SrpingRootConfig;

public class TestDatasource {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SrpingRootConfig.class);
		DataSource ds = context.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql = "Insert into user(`name`, `phone`, `email`, `address`, `loginName`, `password`) values (?,?,?,?,?,?)";
		Object[] param = new Object[] {"Duc Thanh","0974034407","thanhphonui321@gmail.com","Gia Lai","thanhphonui321000sdf","12345678"};
		jt.update(sql, param); 
		System.out.println("Excuted");
		context.close();
	}
}
