/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhnd.interceptor;

import com.thanhnd.domain.User;
import com.thanhnd.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nguyenducthanh
 */
public class MyInterceptor implements HandlerInterceptor {

    List<String> guest = new ArrayList<String>();

    public MyInterceptor() {
        guest.add("");
        guest.add("index");
        guest.add("login");
        guest.add("logout");
        guest.add("pageNotFound");
        guest.add("registerForm");
        guest.add("registerProcess");
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        String mainResource = "";
        String allResource = request.getRequestURI().substring(request.getContextPath().length() + 1);
        if (!allResource.contains("static")) {
            mainResource = allResource;
        }
        if (session == null || session.getAttribute("USER") == null) {
            if (!guest.contains(mainResource)) {
                response.sendRedirect(request.getContextPath()+"/index");
                return false;
            }
        } else {
            User user = (User) session.getAttribute("USER");
            if (user.getRole() == UserService.ROLE_ADMIN) {
                int index = mainResource.indexOf("admin");
                if (index != 0 && !guest.contains(mainResource)) {
                    response.sendRedirect(request.getContextPath()+"/pageNotFound");
                    return false;
                }
            } else if (user.getRole() == UserService.ROLE_USER) {
                int index = mainResource.indexOf("user");
                if (index != 0 && !guest.contains(mainResource)) {
                    response.sendRedirect(request.getContextPath()+"/pageNotFound");
                    return false;
                }
            } else {
                response.sendRedirect(request.getContextPath()+"/pageNotFound");
                return false;
            }
        }

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
