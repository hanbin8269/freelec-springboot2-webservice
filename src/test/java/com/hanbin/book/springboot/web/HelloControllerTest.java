package com.hanbin.book.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다
@WebMvcTest(controllers=HelloController.class) // Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean을 주입받는다
    private MockMvc mvc; // 스프링 MVC 테스트의 시작점이다

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        ResultActions perform = mvc.perform(get("/hello"));

        perform // MockMvc를 통해
                .andExpect(status().isOk()) // Http 200인지 확인 (Status OK)
                .andExpect(content().string(hello)); // Controller에서 hello를 리턴하기 떄문에 값이 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        ResultActions perform = mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)));
        // param - API를 테스트할 때 사용될 요청 파라미터 설정

        perform
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

        // jsonPath - JSON 응답값을 필드별로 검증할 수 있는 메소드
        //          - $를 기준으로 필드명을 명시함
    }
}
