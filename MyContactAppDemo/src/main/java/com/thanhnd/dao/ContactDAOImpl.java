package com.thanhnd.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.thanhnd.domain.Contact;
import com.thanhnd.domain.User;
import com.thanhnd.rm.ContactRowMapper;
import com.thanhnd.rm.UserRowMapper;

@Repository
public class ContactDAOImpl extends NamedParameterJdbcDaoSupport implements ContactDAO {

	@Autowired
	public void setDataSource2(DataSource ds) {
		this.setDataSource(ds);
	}

	public void save(Contact c) {
		// TODO Auto-generated method stub
		String sql = "Insert into contact(userId,name,phone,email,address,remark)"
				+ " values(:userId, :name, :phone, :email, :address, :remark)";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("userId", c.getUserId());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());

//		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		this.getNamedParameterJdbcTemplate().update(sql, ps);
//		int userId = kh.getKey().intValue();
//		u.setUserId(userId);
	}

	public void update(Contact c) {
		// TODO Auto-generated method stub
		String sql = "UPDATE contact " + "SET name = ?,  phone = ?, email=?, address=?, remark=?"
				+ " WHERE contactId=?";
		Object[] args = new Object[] { c.getName(), c.getPhone(), c.getEmail(), c.getAddress(), c.getRemark(),
				c.getContactId() };
		this.getJdbcTemplate().update(sql, args);

	}

	public void delete(Integer contactId) {
		String sql = "Delete from contact where contactId=?";
		this.getJdbcTemplate().update(sql, contactId);

	}

	public Contact findById(Integer contactId) {
		// TODO Auto-generated method stub
		String sql = "Select contactId, userId, name, phone, email, address, remark from contact"
				+ " where contactId =?";
		Contact contact = (Contact) super.getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
		return contact;
	}

	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		String sql = "Select contactId, userId, name, phone, email, address, remark from contact";
		List<Contact> list = super.getJdbcTemplate().query(sql, new ContactRowMapper());
		return list;
	}

	public List<Contact> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		String sql = "Select contactId, userId, name, phone, email, address, remark"
				+ " from contact"
				+ " where "+property+"= ?";
		Object[] params = new Object[] {value};
		List<Contact> list = super.getJdbcTemplate().query(sql, new ContactRowMapper(),params);
		return list;
	};

}
