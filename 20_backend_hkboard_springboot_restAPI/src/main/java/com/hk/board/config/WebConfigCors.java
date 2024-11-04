package com.hk.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigCors implements WebMvcConfigurer{
	//WebMvcConfigCors를 정의하면 컨트롤러에 따로 @CrossOrigin을 설정할 필요없음
	//CORS 정책 제한 허용
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
			    .allowedOrigins("http://localhost:8086"
			    		        ,"http://localhost:8087")
			    .allowedMethods("GET","POST","PUT","DELETE")
			    .allowedHeaders("*")  //요청 해더 허용 여부
			    .allowCredentials(false)  //쿠키 허용 여부
			    .maxAge(3600);  //요청결과를 캐싱할 시간을 설정
	}
}





