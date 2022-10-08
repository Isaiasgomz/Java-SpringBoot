package com.spiringfundamentos.platzi.configuration;

import com.spiringfundamentos.platzi.Bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public MyBean myBean(){
        return new MyBeanImplement();
    }

    @Bean
    public MyOperation myOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency myBeanWithDependency(MyOperation myOperation){
        return new BeanWithDependencyImplement(myOperation);
    }
}