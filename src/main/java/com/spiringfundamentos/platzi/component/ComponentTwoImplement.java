package com.spiringfundamentos.platzi.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("hola desde el segundo componente");
    }
}
