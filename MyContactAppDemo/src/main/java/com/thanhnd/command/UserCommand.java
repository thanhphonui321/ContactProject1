/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhnd.command;

import com.thanhnd.domain.User;

/**
 *
 * @author nguyenducthanh
 */
public class UserCommand {
    private User user;

    public UserCommand() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
