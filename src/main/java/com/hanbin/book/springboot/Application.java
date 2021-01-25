package com.hanbin.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // SpringBootApplication이 있는 위치부터 Bean 읽기나 생성을 시작함
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS를 실행함
    }
}