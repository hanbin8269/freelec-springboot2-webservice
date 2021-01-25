package com.hanbin.book.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}
