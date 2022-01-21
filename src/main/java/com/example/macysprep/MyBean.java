package com.example.macysprep;

import com.example.macysprep.pojos.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyBean {

    @Bean(name = "mybeannn")
    @Scope(scopeName = "prototype")
    public Employee getAnEmployee() {
        return new Employee("Employee1", 200000);
    }
}
