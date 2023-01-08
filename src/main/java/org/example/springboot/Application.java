package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //스프링부트의 자동 설정, 스프링 Bean 읽기와 생성 자동 설정
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);     //run : 내장 WAS 자동설정
    }
}
