package com.thanhnd.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    private int userId;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String name;
    
    @Pattern(regexp = "([0-9]{1,11}){0,1}", message = "Enter a valid number")
    private String phone;
    
    @Pattern(regexp = "(\\w+@\\w+([.]\\w+){1,2}){0,1}", message = "Enter a valid email")
    private String email;
    private String address;
    
    @NotNull(message = "is required")
    @Size(min = 3, message = "Username >= 3 characters")
    private String loginName;
    
    @NotNull(message = "is required")
    @Size(min = 6, message = "Password >= 6 characters")
    private String password;
    private int role;
    private int loginStatus;

    public User() {
        this.role = 2;
        this.loginStatus = 1;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

}
