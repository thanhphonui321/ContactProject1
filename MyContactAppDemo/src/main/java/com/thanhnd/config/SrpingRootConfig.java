package com.thanhnd.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.thanhnd.dao","com.thanhnd.service"})
public class SrpingRootConfig {
	//TODO: Services, DAO, DataSource, Email sender or some business layer beans

	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/capp_app");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setMaxTotal(2);
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("Select 1");
		ds.setDefaultAutoCommit(true);
		return ds;
	}
}
