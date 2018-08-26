package com.thanhnd.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.thanhnd.dao.UserDAO;
import com.thanhnd.domain.User;
import com.thanhnd.exception.BlockedUserException;
import com.thanhnd.rm.UserRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class UserServiceImpl extends NamedParameterJdbcDaoSupport implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    public void setDataSource2(DataSource ds) {
        this.setDataSource(ds);
    }

    public void register(User u) {
        // TODO Auto-generated method stub
        userDAO.save(u);

    }

    public User login(String username, String password) throws BlockedUserException {
        // TODO Auto-generated method stub
        String sql = "Select userId, name, phone, email, address, loginName, password, role, loginStatus from user"
                + " where loginName =? AND password = ?";
        try {
            User user = (User) getJdbcTemplate().queryForObject(sql, new UserRowMapper(), new Object[]{username, password});
            if (user.getLoginStatus() == UserService.LOGIN_STATUS_BLOCKED) {
                throw new BlockedUserException("Your account has been blocked. Contact to admin please. ");
            }
            return user;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    public List<User> viewAllUser() {
        // TODO Auto-generated method stub
        return userDAO.findAll();
    }

    public void changeStatusUser(int userId, int status) {
        // TODO Auto-generated method stub
        String sql = "UPDATE user SET loginStatus=? WHERE userId=?";
        Object[] args = new Object[]{
            status,
            userId
        };
        this.getJdbcTemplate().update(sql, args);

    }

    public boolean checkUsername(String username) {
        String sql = "SELECT count(loginName) from user where loginName = ?";
        Object[] args = new Object[]{
            username
        };
        int result = this.getJdbcTemplate().queryForObject(sql, args, Integer.class);
        if (result == 1){
            return false;
        }
        else {
            return true;
        }
    }

}
