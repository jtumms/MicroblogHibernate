package com.tummsmedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by john.tumminelli on 10/23/16.
 */
@Controller
public class MicroblogHibernateController {
    @Autowired
    MessageRepostitory messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Iterable<Message> messagelist = messages.findAll();
        model.addAttribute("messages", messagelist);
        return "index";
    }

    @RequestMapping(path = "/create-message", method = RequestMethod.POST)
    public String createMessage(String message) {
        Message m = new Message(message);
        messages.save(m);
        return "redirect:/create-message";
    }
}
