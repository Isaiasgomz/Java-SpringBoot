package com.spiringfundamentos.platzi.Bean;

public class BeanWithDependencyImplement  implements  MyBeanWithDependency{

    private MyOperation myOperation;

    public BeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 1;
        System.out.println(myOperation.suma(number));
        System.out.println("hola desde un bean con dependencia");

    }
}
