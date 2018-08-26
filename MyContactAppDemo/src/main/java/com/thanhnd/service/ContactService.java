package com.thanhnd.service;

import java.util.List;

import com.thanhnd.domain.Contact;

/**
 * Business operation for contact entity
 * 
 * @author nguyenducthanh
 *
 */
public interface ContactService {
	public void save(Contact c);
	public void update(Contact c);
	public void delete(int contactId);
	public void delete(int[] contactIds);
        public Contact findById(int contactId);
	public List<Contact> findAllContact(int userId);
	/**
	 * 
	 * @param userId
	 * @param txt for free search
	 * @return list of contact found by the param 'txt'
	 */
	public List<Contact> findSearchContact(int userId, String txt);
}
