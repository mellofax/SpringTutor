package com.example.springtutor.controller;

import com.example.springtutor.exception.ControllerException;
import com.example.springtutor.exception.ServiceException;
import com.example.springtutor.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code) throws ControllerException {
        try {
            userService.activateUser(code);
            return "login";
        } catch (ServiceException e) {
            log.error("[MainController] error activate user");

            throw new ControllerException("activate", e);
        }
    }
}
