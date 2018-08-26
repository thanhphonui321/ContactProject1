/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhnd.command;

import com.thanhnd.domain.Contact;

/**
 *
 * @author nguyenducthanh
 */
public class ContactCommand {
    private Contact contact;

    public ContactCommand() {
    }

    public ContactCommand(Contact contact) {
        this.contact = contact;
    }
    

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    
}
