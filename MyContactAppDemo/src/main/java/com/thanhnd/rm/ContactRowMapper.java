package com.thanhnd.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thanhnd.domain.Contact;
import com.thanhnd.domain.User;

public class ContactRowMapper implements RowMapper{

	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Contact contact = new Contact();
		contact.setContactId(rs.getInt("contactId"));
		contact.setUserId(rs.getInt("contactId"));
		contact.setName(rs.getString("name"));
		contact.setPhone(rs.getString("phone"));
		contact.setEmail(rs.getString("email"));
		contact.setAddress(rs.getString("address"));
		contact.setRemark(rs.getString("remark"));
		return contact;
	}
	
}
