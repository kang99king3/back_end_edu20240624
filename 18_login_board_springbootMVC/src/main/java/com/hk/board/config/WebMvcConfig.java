package com.hk.board.config;

import org.springframework.context.annotation.Configuration;
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
				.excludePathPatterns("/error",
						             "/board/boardList"
									,"/board/boardDetail"
									,"/board/mulDel"
									,"/board/boardUpdate"
									,"/board/download"
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
}





