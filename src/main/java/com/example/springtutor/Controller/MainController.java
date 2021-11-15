package com.example.springtutor.Controller;

import com.example.springtutor.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String index(Model model){
        return "login";
    }

    @GetMapping(value = "/login")
    public String login(Model model){
        return "Home";
    }

    @GetMapping(value = "/registration")
    public String registration(Model model){
        return "registration";
    }

}
