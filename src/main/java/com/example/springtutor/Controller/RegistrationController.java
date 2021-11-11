package com.example.springtutor.Controller;

import com.example.springtutor.Entity.UserDB;
import com.example.springtutor.Forms.UserForm;
import com.example.springtutor.Repository.UserRepository;
import com.example.springtutor.logger.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.example.springtutor.logger.Errors.getError;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = {"/registration"})
    public ModelAndView showAddDisciplinePage(Model model) {
        ModelAndView modelAndView = new ModelAndView("registration");
        UserForm userForm = new UserForm();
        model.addAttribute("userform", userForm);
        return modelAndView;
    }

    @PostMapping(value = {"/newuser"})
    public ModelAndView saveDiscipline(Model model, @ModelAttribute("userform") UserForm userForm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        try {
            String name = userForm.getName();
            String login = userForm.getLogin();
            String password = userForm.getPassword();
            String reppass = userForm.getReppass();
            UserDB user = new UserDB(name, login, password);
            userRepository.save(user);
            Log.getLogger().info("Registration is successfully!");
            return modelAndView;
        }catch (Exception e){
            model.addAttribute("errorMessage", getError(e.getMessage()));
            modelAndView.setViewName("registration");
            return modelAndView;
        }
    }
}
