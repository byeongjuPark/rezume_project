package com.example.rezume_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration {
    
    private final AuthenticationFailureHandler customFailureHandler;    //@RequiredArgsConstructor랑 같이 써야 final이 의존성 주입 됨.
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
            .authorizeHttpRequests()
            .requestMatchers("/edit").hasRole("USER")
            .anyRequest().permitAll();

        httpSecurity
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/api/login")
                .failureHandler(customFailureHandler)
                .defaultSuccessUrl("/")
            .and()
                .logout()
                .logoutUrl("/logout") // /logout post 방식
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
            .and()
                .csrf().disable();

            return httpSecurity.build();
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
 
}


// @Bean // filterChain 하나의 클래스로 여김(관리대상으로 여김)
//     public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

//         // 권한에 대한: url & roles : user url & role
//         httpSecurity.authorizeHttpRequests()
//                 .requestMatchers("/edit/*").hasRole("USER")
//                 .anyRequest().permitAll(); // 모두가 접속할 수 있는,로그인 필요x

//         // 로그인에 대한
//         httpSecurity.formLogin()
//                 .loginPage("/login") // 로그인을 하면 페이지를 지정
//                 .defaultSuccessUrl("/") // 로그인 성공 후 이동 페이지
//                 .failureUrl("/login") // 로그인 실패 후 이동 페이지
//                 .usernameParameter("userId") // 아이디 파라미터명 설정, default: username
//                 .passwordParameter("passwd")
//                 .loginProcessingUrl("/login_proc")
//                 .successHandler( // 로그인 성공 후 핸들러
//                     new AuthenticationSuccessHandler() { // 익명 객체 사용
//                         @Override
//                         public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                         System.out.println("authentication: " + authentication.getName());
//                         response.sendRedirect("/");
//                         }
//                     })
//                 .failureHandler( // 로그인 실패 후 핸들러
//                     new AuthenticationFailureHandler() { // 익명 객체 사용
//                         @Override
//                         public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//                         System.out.println("exception: " + exception.getMessage());
//                         response.sendRedirect("/login");
//                         }
//                     })
//                     .permitAll()
//                 ;


//         return httpSecurity.build();
//     }