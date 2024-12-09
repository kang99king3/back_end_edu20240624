package com.hk.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	//구현된 interceptor 객체를 등록한다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				.order(1) //우선순위 설정
				.addPathPatterns("/**")   //전체 요청에 대해 적용
				.excludePathPatterns("/error"
									,"/sendMail/**"
//									,"/board/**"
//						            , "/board/boardlist"
//									,"/board/boarddetail"
//									,"/board/muldel"
//									,"/board/boardupdate"
//									,"/board/download"
						            ,"/","/user/**","/css/**","/js/**"
						            ,"/img/**","/upload/**");
	
//		registry.addInterceptor(new LoginInterceptor())
//		.order(2)
//		.addPathPatterns("/**")   //전체 요청에 대해 적용
//		.excludePathPatterns("/board","/","/user/**","/css/**","/js/**");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("user.dir:"+System.getProperty("user.dir"));
		registry.addResourceHandler("/upload/**")
				.addResourceLocations("file:"+System.getProperty("user.dir")+"/src/main/webapp/upload/");
	}
	
	//spring security에서 cors와 충돌되기 때문에 먼저 실행되는 security에 cors를 설정하고, spring MVC에서는 생략하여 통합함
	//WebMvcConfigCors를 정의하면 컨트롤러에 따로 @CrossOrigin을 설정할 필요없음
	//CORS 정책 제한 허용
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//			    .allowedOrigins("http://localhost:3000")
//			    .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","HEAD")
//			    .allowedHeaders("*")  //요청 해더 허용 여부
//			    .allowCredentials(true)  //쿠키 허용 여부
//			    .maxAge(3600);  //요청결과를 캐싱할 시간을 설정
//	}
	
	
}





