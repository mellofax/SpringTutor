package com.example.springtutor.Controller;

import com.example.springtutor.Entity.UserDB;
import com.example.springtutor.Forms.UserForm;
import com.example.springtutor.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;

import static com.example.springtutor.logger.Errors.getError;


@Controller
@RequestMapping
public class MainController {

    @Autowired
    private UserRepository userRepository;
    private UserDB admin = new UserDB("Admin", "Admin", "Admin123", true);

    @GetMapping(value = "/")
    public String index(Model model){
        if(!FindAdmin())
            CreateAdmin();
        return "login";
    }
    @GetMapping(value = "/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration(Model model){
        return "registration";
    }

    private boolean FindAdmin(){
        for(UserDB users : userRepository.findAll()){
            if(admin.AdminCheck(users))
                return true;
        }
        return false;
    }
    private void CreateAdmin(){
        userRepository.save(admin);
    }
}
