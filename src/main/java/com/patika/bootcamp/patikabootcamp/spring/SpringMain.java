package com.patika.bootcamp.patikabootcamp.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringMain.class);

        Sport sport = (Sport) context.getBean("xyz");
        System.out.println(sport.getSportName());
    }
}
