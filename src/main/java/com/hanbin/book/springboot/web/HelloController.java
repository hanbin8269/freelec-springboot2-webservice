package com.hanbin.book.springboot.web;
import com.hanbin.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어줌 (메서드마다 @ResponseBody)
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        // @RequestParam - 외부에서 API로 넘긴 파라미터를 가져옴
        // 외부에서 name 이란 이름으로 넘긴 파라미터를 메소드 파라미터 name에 저장하게 된다.
        return new HelloResponseDto(name, amount);
    }
}
