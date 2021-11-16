package com.example.springtutor.Controller;

import com.example.springtutor.DTO.UserDto;
import com.example.springtutor.Entity.User;
import com.example.springtutor.Repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.example.springtutor.service.Errors.getError;

@Tag(name = "Регистрация", description = "Контролирует регистрацию пользователей")
@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = {"/registration"})
    public ModelAndView showAddDisciplinePage(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userdto", userDto);
        return new ModelAndView("registration");
    }

    @PostMapping(value = {"/newuser"})
    public ModelAndView saveDiscipline(Model model,@ModelAttribute("userdto") UserDto userDto) {
        try {
            String email = userDto.getEmail();
            String login = userDto.getLogin();
            String password = userDto.getPassword();
            if(!checkUser(login, email))
                throw new Exception("User Exist");
            User user = new User(email, login, password);
            userRepository.save(user);
            return new ModelAndView("redirect:/");
        }catch (Exception e){
            System.out.println(getError(e.getMessage()));
            model.addAttribute("errorMessage", getError(e.getMessage()));
            return new ModelAndView("registration");
        }
    }
    private boolean checkUser(String login, String email){
        User LoginFromDb =userRepository.findByLogin(login);
        User EmailFromDb =userRepository.findByEmail(email);
        if(LoginFromDb!= null || EmailFromDb != null)
            return false;
        else return true;
    }

}
