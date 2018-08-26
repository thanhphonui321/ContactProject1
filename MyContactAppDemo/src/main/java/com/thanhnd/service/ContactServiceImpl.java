package com.thanhnd.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.thanhnd.dao.ContactDAO;
import com.thanhnd.domain.Contact;
import com.thanhnd.domain.User;
import com.thanhnd.rm.ContactRowMapper;

@Service
public class ContactServiceImpl extends NamedParameterJdbcDaoSupport implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	@Autowired
	public void setDataSource2(DataSource ds) {
		this.setDataSource(ds);
	}

	public void save(Contact c) {
		// TODO Auto-generated method stub
		contactDAO.save(c);

	}

	public void update(Contact c) {
		// TODO Auto-generated method stub
		contactDAO.update(c);

	}

	public void delete(int contactId) {
		// TODO Auto-generated method stub
		contactDAO.delete(contactId);

	}

	public void delete(int[] contactIds) {
		// TODO Auto-generated method stub
		for (int i = 0; i < contactIds.length; i++) {
			delete(contactIds[i]);
		}

	}

	public List<Contact> findAllContact(int userId) {
		// TODO Auto-generated method stub
		return contactDAO.findByProperty("userId", userId);
	}

	public List<Contact> findSearchContact(int userId, String txt) {
		// TODO Auto-generated method stub
		String sql = "Select contactId, userId, name, phone, email, address, remark from contact"
				+ "	where userId = ? AND (name like ? OR email like ? OR address like ? OR remark like ?)";
		
		Object[] args = new Object[] {
				userId,
				"%"+txt+"%",
				"%"+txt+"%",
				"%"+txt+"%",
				"%"+txt+"%"
				};
		
		List<Contact> list = this.getJdbcTemplate().query(sql, new ContactRowMapper(),args);
		return list;
	}

    public Contact findById(int contactId) {
        return contactDAO.findById(contactId);
    }

}
