package com.tummsmedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

//        Iterable<Message> messagelist = messages.findAll();
//        model.addAttribute("messages", messagelist);
        return "index";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String enterLogin(String loginName, String password) {
        User user = new User();
        user = new User(loginName, password);

        return "redirect:/newuser";

        //return "redirect:/create-message";
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
}

//    @RequestMapping(path = "/create-message", method = RequestMethod.POST)
//    public String createMessage(String message) {
//        Message m = new Message(message);
//        messages.save(m);
//        return "redirect:/create-message";
//    }
