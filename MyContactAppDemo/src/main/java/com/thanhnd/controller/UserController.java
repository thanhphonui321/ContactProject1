package com.thanhnd.controller;

import com.thanhnd.command.LoginCommand;
import com.thanhnd.command.UserCommand;
import com.thanhnd.domain.User;
import com.thanhnd.exception.BlockedUserException;
import com.thanhnd.service.UserService;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.BindingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/pageNotFound"})
    public String showNotFound() {
        return "pageNotFound";
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index?act=lo";
    }

    @RequestMapping(value = {"/index", "/"})
    public String showLoginForm(Model m) {
        m.addAttribute("login", new LoginCommand());
        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String processLoginForm(Model m, @ModelAttribute("login") LoginCommand cmd, HttpSession session) {
        try {
            User user = userService.login(cmd.getUsername(), cmd.getPassword());
            if (user == null) {
                m.addAttribute("err", "Wrong username or password. Please login again.");
                return "index";
            } else {
                if (user.getRole() == UserService.ROLE_ADMIN) {
                    session.setAttribute("USER", user);
                    return "redirect:admin/dashboard";
                } else if (user.getRole() == UserService.ROLE_USER) {
                    session.setAttribute("USER", user);
                    return "redirect:user/dashboard";
                } else {
                    m.addAttribute("err", "Invalid role");
                    return "index";
                }
            }
        } catch (BlockedUserException ex) {
            m.addAttribute("err", ex.getMessage());
            return "index";
        }
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public String processRegisterForm(Model m, @Valid @ModelAttribute("command") User cmd,
             BindingResult theBindingResult) {
        try {
            if (theBindingResult.hasErrors()){
                return "registerForm";
            }
            userService.register(cmd);
            return "redirect:index?act=reg";
        } catch (DuplicateKeyException e) {
            m.addAttribute("err", "This username already existed. Try another username !!!");
            return "registerForm";
        }
    }

    @RequestMapping("/registerForm")
    public String showRegisterForm(Model m) {
        m.addAttribute("command", new User());
        return "registerForm";
    }

    @RequestMapping(value = {"/user/dashboard"})
    public String userDashboard() {
        return "dashboard_user";
    }

    @RequestMapping(value = {"/admin/dashboard"})
    public String adminDashboard() {
        return "dashboard_admin";
    }

    @RequestMapping(value = {"/admin/vlist"})
    public String showListUser(Model m) {
        m.addAttribute("listUser", userService.viewAllUser());
        return "vlist";
    }

    @RequestMapping(value = {"/admin/change_status"})
    @ResponseBody
    public String changeStatus(@RequestParam("userId") int userId, @RequestParam("loginStatus") int status) {
        try {
            userService.changeStatusUser(userId, status);
            return "SUCCESS";
        } catch (DataAccessException e) {
            e.printStackTrace();
            return "FAILED";
        }
    }

    @RequestMapping(value = {"/checkUsername"})
    @ResponseBody
    public String check_username(@RequestParam("username") String username) {
        if (userService.checkUsername(username) == true) {
            return "1";
        }
        return "0";
    }

}
