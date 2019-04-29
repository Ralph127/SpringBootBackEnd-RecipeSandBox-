package io.project.classproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "io.project.classproject.repository")
public class ClassprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassprojectApplication.class, args);
    }


}
