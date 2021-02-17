package com.hanbin.book.springboot.config.auth;

import com.hanbin.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()// 이게 있어야 antMatcher 사용 가능 (URL 별 권한 관리)
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated() // 설정된 URL 이외의 나머지 URL
                .and()
                    .logout()
                        .logoutSuccessUrl("/") // 로그아웃 시 / 주소로 이동
                .and()
                    .oauth2Login() // Oauth2 로그인 기능에 대한 진입점
                        .userInfoEndpoint() // Oauth2 로그인 성공 이루 사용자 정보를 가져올 때의 설정
                            .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체

    }
}
