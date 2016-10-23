package com.tummsmedia;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by john.tumminelli on 10/23/16.
 */
@Controller
public class MicroblogHibernateController {
    //HashMap<String, User> userHashMap = new HashMap<>();

    @Autowired
    MessageRepostitory messages;
    @Autowired
    UserRepository users;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String enterLogin(Model model, String loginName, String password, HttpSession session) {
        User user = users.findFirstByName(loginName);
        if(!user.password.equals(password)){
            return "redirect:/login";
        }
        session.setAttribute("loginName", loginName);
        return "redirect:/create-message";
    }

    @RequestMapping(path = "/newuser", method = RequestMethod.GET)
    public String newUser(){
        return "newuser";
    }
    @RequestMapping(path = "/newuser", method = RequestMethod.POST)
    public String addUser(String loginName, String password) {
        User user = new User(loginName, password);
        users.save(user);
        return "redirect:/";
    }
    @RequestMapping(path = "/create-message", method = RequestMethod.GET)
    public String createMessage(Model model){
        Iterable<Message> messagelist = messages.findAll();
        model.addAttribute("messages", messagelist);
        return "create-message";
    }
    @RequestMapping(path = "/create-message", method = RequestMethod.POST)
    public String addMessage(String message) {
        Message m = new Message(message);
        messages.save(m);
        return "redirect:/create-message";
    }
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String deleteMessage(String id) {
        messages.delete(Integer.valueOf(id));
        return "redirect:/create-message";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(String id, HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String editMessage(String id, String edit){
        Message msg = messages.findById(Integer.valueOf(id));
        msg.setText(edit);
        messages.save(msg);
        return "redirect:/create-message";
    }

}

