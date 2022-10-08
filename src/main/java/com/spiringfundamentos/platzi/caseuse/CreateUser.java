package com.spiringfundamentos.platzi.caseuse;

import com.spiringfundamentos.platzi.entity.User;
import com.spiringfundamentos.platzi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return  userService.saveUser(newUser);
    }
}
