package com.spiringfundamentos.platzi.caseuse;

import com.spiringfundamentos.platzi.entity.User;
import com.spiringfundamentos.platzi.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, Long id) {
       return userService.update(newUser,id);
    }
}
