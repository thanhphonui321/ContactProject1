 package com.thanhnd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.thanhnd.domain.User;
import com.thanhnd.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{
	
	@Autowired
	public void setDataSource2(DataSource ds) {
		this.setDataSource(ds);
	}

	public void save(User u) {
		// TODO Auto-generated method stub
		String sql = "Insert into user(name,phone,email,address,loginName,password,role,loginStatus)"
				+ " values(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		
//		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		this.getNamedParameterJdbcTemplate().update(sql, ps);
//		int userId = kh.getKey().intValue();
//		u.setUserId(userId);
		
		
	}

	public void update(User u) {
		// TODO Auto-generated method stub
		String sql = "UPDATE user " + 
				"SET name = ?,  phone = ?, email=?, address=?, "
				+ " loginName=?, password=?, role=?, loginStatus=?" + 
				" WHERE userId=?";
		Object[] args = new Object[] {
				u.getName(),
				u.getPhone(),
				u.getEmail(),
				u.getAddress(),
				u.getLoginName(),
				u.getPassword(),
				u.getRole(),
				u.getLoginStatus(),
				u.getUserId()
				};
		this.getJdbcTemplate().update(sql, args);
		
	}

	public void delete(Integer userId) {
		String sql = "Delete from user where userId=?";
		this.getJdbcTemplate().update(sql, userId);
		
	}

	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		String sql = "Select userId, name, phone, email, address, loginName, password, role, loginStatus"
				+ " from user"
				+ " where userId =?";
		User user = (User) super.getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
		return user;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "Select userId, name, phone, email, address, loginName, password, role, loginStatus"
				+ " from user where role = 2";
		List<User> list = super.getJdbcTemplate().query(sql, new UserRowMapper());
		return list;
	}

	public List<User> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		String sql = "Select userId, name, phone, email, address, loginName, password, role, loginStatus"
				+ " from user"
				+ " where "+property+" = ?";
		Object[] params = new Object[] {value};
		List<User> list = super.getJdbcTemplate().query(sql, new UserRowMapper(),params);
		return list;
	}

}
