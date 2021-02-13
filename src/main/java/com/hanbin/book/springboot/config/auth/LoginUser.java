package com.hanbin.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 이 어노테이션이 생성 될 수 있는 위치 (메소드의 파라미터로 선언된 객체에서 사용할 수 있음)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
