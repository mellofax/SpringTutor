package com.example.springtutor.Controller;

import com.example.springtutor.Entity.User;
import com.example.springtutor.Forms.UserForm;
import com.example.springtutor.Repository.UserRepository;
import com.example.springtutor.logger.Log;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String saveDiscipline(Model model, @ModelAttribute("userform") UserForm userForm) {
        try {
            String email = userForm.getEmail();
            String login = userForm.getLogin();
            String password = userForm.getPassword();
            User user = new User(email, login, password, false);
            userRepository.save(user);
            Log.getLogger().info("Registration is successfully!");
            return "redirect:/";
        }catch (Exception e){
            model.addAttribute("errorMessage", getError(e.getMessage()));
            return "registration";
        }
    }

}
