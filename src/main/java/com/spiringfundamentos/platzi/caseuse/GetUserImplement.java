package com.spiringfundamentos.platzi.caseuse;

import com.spiringfundamentos.platzi.entity.User;
import com.spiringfundamentos.platzi.service.UserService;

import java.util.List;

public class GetUserImplement implements  GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getUsers() {
       return userService.getAllUsers();
    }
}
