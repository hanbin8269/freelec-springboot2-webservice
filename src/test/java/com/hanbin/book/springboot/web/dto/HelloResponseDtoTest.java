package com.hanbin.book.springboot.web.dto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void 롬북_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // isEqualTo와 같이 메서드를 이어서 사용할 수 있음
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
