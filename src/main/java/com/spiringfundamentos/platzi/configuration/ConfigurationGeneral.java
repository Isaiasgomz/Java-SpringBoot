package com.spiringfundamentos.platzi.configuration;

import com.spiringfundamentos.platzi.Bean.BeanWithProperties;
import com.spiringfundamentos.platzi.Bean.BeanWithPropertiesImplement;
import com.spiringfundamentos.platzi.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.sql.DataSource;

@EnableConfigurationProperties(UserPojo.class)
@PropertySource("classpath:connection.properties")
@Configuration
public class ConfigurationGeneral {

    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;


    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username")
    private String username;

    @Value("${password")
    private String password;

    @Bean
    BeanWithProperties funtion(){
        return new BeanWithPropertiesImplement(name,apellido);
    }


    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);

        return dataSourceBuilder.build();

    }
}
