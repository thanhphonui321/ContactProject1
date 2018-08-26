/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhnd.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nguyenducthanh
 */
@Controller
public class TestController {
    
    @RequestMapping("/test/ajax_test")
    public String testPage(){
        return "test";
    }
    
    @RequestMapping("/test/get_Time")
    @ResponseBody
    public String getTimeTest(){
        Date date = new Date();
        return date.toString();
    }
    
}
