package com.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = com.quiz.controller.PreguntasController.class)
public class QuizApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }
}

