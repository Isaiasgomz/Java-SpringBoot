package com.spiringfundamentos.platzi.configuration;

import com.spiringfundamentos.platzi.caseuse.GetUser;
import com.spiringfundamentos.platzi.caseuse.GetUserImplement;
import com.spiringfundamentos.platzi.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUsers(UserService userService){
        return new GetUserImplement(userService);
    }
}
