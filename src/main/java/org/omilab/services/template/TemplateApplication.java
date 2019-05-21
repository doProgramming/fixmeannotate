package org.omilab.services.template;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
@EnableJpaRepositories
public class TemplateApplication {

 public static void main(String[] args) {
                SpringApplication.run(TemplateApplication.class, args);
        }



}
