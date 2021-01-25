package com.hanbin.book.springboot.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어줌 (메서드마다 @ResponseBody)
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
