/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhnd.controller;

import com.thanhnd.command.ContactCommand;
import com.thanhnd.domain.Contact;
import com.thanhnd.domain.User;
import com.thanhnd.service.ContactService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nguyenducthanh
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = {"/user/saveContactForm"})
    public String showContactForm(Model m, HttpSession session) {
        session.removeAttribute("cIdForEdit");
        m.addAttribute("command", new Contact());
        return "saveContactForm";
    }

    @RequestMapping(value = {"/user/saveContactProcess"})
    public String processContactForm(Model m, HttpSession session, @Valid @ModelAttribute("command") Contact cmd,
            BindingResult theBindingResult) {
        try {
            if (theBindingResult.hasErrors()) {
                return "saveContactForm";
            }
            int userId = ((User) session.getAttribute("USER")).getUserId();
            if (session.getAttribute("cIdForEdit") == null) {
                cmd.setUserId(userId);
                contactService.save(cmd);
            } else {
                Integer cId = (Integer) session.getAttribute("cIdForEdit");
                cmd.setContactId(cId);
                contactService.update(cmd);
                session.removeAttribute("cIdForEdit");
            }

            return "redirect:clist?act=saved";
        } catch (DataAccessException e) {
            m.addAttribute("err", "Failed, please try again");
            return "saveContactForm";
        }
    }

    @RequestMapping(value = {"/user/clist"})
    public String viewListContact(Model m, HttpSession session) {
        int userId = ((User) session.getAttribute("USER")).getUserId();
        m.addAttribute("listContact", contactService.findAllContact(userId));
        return "clist";
    }

    @RequestMapping(value = {"/user/deleteContact"})
    public String deleteContact(Model m, @RequestParam("contactId") int contactId) {
        try {
            contactService.delete(contactId);
            return "redirect:clist?act=deleted";
        } catch (DataAccessException e) {
            m.addAttribute("err", "Delete failed");
            return "redirect:clist";
        }
    }

    @RequestMapping(value = {"/user/multipleDelete"}, method = RequestMethod.POST)
    public String deleteMultipleContact(Model m, @RequestParam(value = "mulDelValue", required = false) int[] contactIds) {
        try {
            if (contactIds != null) {
                contactService.delete(contactIds);
                return "redirect:clist?act=deleted";
            }
        } catch (DataAccessException e) {
            m.addAttribute("err", "Delete failed");
        }
        return "redirect:clist";
    }

    @RequestMapping(value = {"/user/searchContact"})
    public String searchContact(@RequestParam("searchValue") String searchValue, Model m, HttpSession session) {
        try {
            int userId = ((User) session.getAttribute("USER")).getUserId();
            m.addAttribute("listContact", contactService.findSearchContact(userId, searchValue));
        } catch (DataAccessException e) {
            m.addAttribute("err", "Search failed");
        }
        return "clist";
    }

    @RequestMapping(value = {"/user/prepare_edit"})
    public String prepareEdit(Model m, @RequestParam("contactId") int contactId, HttpSession session) {
        session.setAttribute("cIdForEdit", contactId);
        Contact c = contactService.findById(contactId);
        m.addAttribute("command", c);
        return "saveContactForm";
    }
}
