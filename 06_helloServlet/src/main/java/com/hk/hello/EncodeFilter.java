package com.hk.hello;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

//urlmapping 방법 2가지 (xml, 어노테이션)
@WebFilter(
		urlPatterns = { "/*","/a","/b" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class EncodeFilter extends HttpFilter implements Filter {

	private String encode;
	
	public void init(FilterConfig fConfig) throws ServletException {
		encode=fConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		//요청했을때 실행할 코드
		System.out.println("요청했을때 코드 실행");
		request.setCharacterEncoding(encode);
		response.setContentType("text/html;charset="+encode);
		System.out.println("요청 URL: " + ((HttpServletRequest)request).getRequestURI());
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println("응답했을때 코드 실행");
	}


	public void destroy() {
		
	}
}
