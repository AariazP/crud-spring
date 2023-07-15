package com.org.crudspringweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan({"com.org.crudspringweb.controllers", "com.org.crudspringweb.services"})
public class CrudSpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringWebApplication.class, args);
    }

}
