package com.example.springtutor.controller;

import com.example.springtutor.bean.User;
import com.example.springtutor.config.jwt.JwtProvider;
import com.example.springtutor.controller.dto.AuthRequest;
import com.example.springtutor.controller.dto.AuthResponse;
import com.example.springtutor.controller.dto.RegistrationRequest;
import com.example.springtutor.controller.dto.UserResponse;
import com.example.springtutor.exception.ControllerException;
import com.example.springtutor.exception.ServiceException;
import com.example.springtutor.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;;

import java.util.List;

@Slf4j
@Tag(name = "Главная", description = "Контролирует переход между страницами")
@RestController
public class MainRestController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping("/users")
    public List<User> getUsers() throws ControllerException {
        try {
            log.debug("[MainRestController] getting all users");
            return userServiceImpl.findAll();
        } catch (Exception e) {
            log.error("[MainRestController] error get all users");
            throw new ControllerException("getUsers", e);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) throws ControllerException {
        try {
            log.debug("[MainRestController] try to register user");
            if (!userServiceImpl.existsUserByLogin(registrationRequest.getLogin())) {
                User u = new User();
                u.setPassword(registrationRequest.getPassword());
                u.setLogin(registrationRequest.getLogin());
                u.setEmail(registrationRequest.getEmail());
                userServiceImpl.saveUser(u);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FOUND);
            }
        } catch (ServiceException e) {
            log.error("[MainRestController] error register user");
            throw new ControllerException("registerUser", e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> auth(@RequestBody AuthRequest request) throws ControllerException {
        try {
            log.debug("[MainRestController] try to login user");
            User user = userServiceImpl.findByLoginAndPassword(request.getLogin(), request.getPassword());
            if (user != null && user.isActive()) {
               String token = jwtProvider.generateToken(user.getLogin());
               AuthResponse response = new AuthResponse(token, user.getUserRole().getName());
               return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                throw new ControllerException("not such user");
            }
        } catch (ServiceException e) {
            log.error("[MainRestController] error login");
            throw new ControllerException("auth", e);
        }
    }

    @PostMapping("/authorized")
    public ResponseEntity<?> isAuthorized() throws ControllerException {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/getUser")
    public UserResponse getUser(@RequestHeader(name = "Authorisation") String jwt) throws ControllerException {
        try {
            log.debug("[MainRestController] get user by token");
            String userName = jwtProvider.getLoginFromToken(jwt.substring(7));
            User user = userServiceImpl.findByLogin(userName);
            return new UserResponse(user.getId(), user.getLogin(), user.getUserRole().getName());
        } catch (ServiceException e) {
            log.error("[MainRestController] error get user");

            throw new ControllerException("getUser", e);
        }
    }
}
