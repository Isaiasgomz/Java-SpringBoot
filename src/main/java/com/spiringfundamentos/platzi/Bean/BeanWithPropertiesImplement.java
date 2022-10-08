package com.spiringfundamentos.platzi.Bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanWithPropertiesImplement implements BeanWithProperties{

    private  final Log log = LogFactory.getLog(BeanWithPropertiesImplement.class);
    private String name;
    private String apellido;

    public BeanWithPropertiesImplement(String name, String apellido) {
        this.name = name;
        this.apellido = apellido;
    }


    @Override
    public String function() {
        log.debug("estamos entrnado en la union de 2 strings el name:"+name);
        return name+"-"+apellido;
    }
}
