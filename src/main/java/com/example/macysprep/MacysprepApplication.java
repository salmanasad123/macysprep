package com.example.macysprep;

import com.example.macysprep.pojos.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class MacysprepApplication {

    public static void main(String[] args) {
        SpringApplication.run(MacysprepApplication.class, args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBean.class);
        Employee employee = (Employee) applicationContext.getBean("mybeannn");
        Employee employee1 = (Employee) applicationContext.getBean("mybeannn");

        System.out.println(employee);
        System.out.println(employee1);
    }
    
}
