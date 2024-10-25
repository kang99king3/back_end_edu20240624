package com.hk.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
//	authorizeRequests() : 시큐리티 처리에 HttpServletRequest를 사용한다는 것을 의미
//	requestMatchers("주소") : 지정한 주소에 대해 예외를 두어 설정
//	permitAll() : 앞에 지정한 주소를 모두에게 접근 허가
//	anyRequest().authenticated() : 다른 어떤 접근에도 보안 검사를 한다.
//	formLogin().loginPage("주소") : 로그인 페이지로 주소값으로 이동 설정
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
//		http.cors().disable().csrf().disable();// 버전업되면서 안씀
		
//		http.csrf(AbstractHttpConfigurer::disable)
//	    .cors(AbstractHttpConfigurer::disable)
//	    .authorizeHttpRequests(request -> request
//	    		.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//	    		.requestMatchers(new MvcRequestMatcher(new HandlerMappingIntrospector(),"/")
//	    					    ,new MvcRequestMatcher(new HandlerMappingIntrospector(),"/login/**")
//	    					    ,new MvcRequestMatcher(new HandlerMappingIntrospector(),"/**/error")).permitAll()
//	    		.requestMatchers(new MvcRequestMatcher(new HandlerMappingIntrospector(),"/")
//					            ,new MvcRequestMatcher(new HandlerMappingIntrospector(),"/css/**")
//					            ,new MvcRequestMatcher(new HandlerMappingIntrospector(),"/js/**")
//					            ,new MvcRequestMatcher(new HandlerMappingIntrospector(),"/img/**")
//					            ).permitAll()
//	    		.anyRequest().authenticated()
//	    		)
//	    .formLogin(login -> login
//		         .loginPage("/user/login")
//		         .defaultSuccessUrl("/",true)  // true를 설정해야 이동함. -> 성공하면 무조건 설정한 URL로 감
//		         .usernameParameter("id")
//		         .failureUrl("/members/login/error")
//		         .permitAll()
//				 );
		                          // /board/list   ,  http://naver.com/dev/source
		// 기능 비활성화    cors : service1 -----> service2: data가져올수 없게 처리
		http.cors(AbstractHttpConfigurer::disable) 
		    .csrf(AbstractHttpConfigurer::disable) // cors,csrf 비활성화
		    .formLogin(AbstractHttpConfigurer::disable);//loginform 비활성화
		
		return http.build();
	}
	
	//패스워드 암호화 객체
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}




