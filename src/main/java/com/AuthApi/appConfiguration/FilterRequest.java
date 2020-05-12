package com.AuthApi.appConfiguration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import com.AuthApi.model.User;
import com.AuthApi.repository.UserRepo;

@ComponentScan
@Configuration
public class FilterRequest implements javax.servlet.Filter {

	@Autowired
	UserRepo userRepo;
		
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;
		
		String uri=httpServletRequest.getRequestURI();
		if(uri.equals("/api/dummy") || uri.equals("/api/logout")) {
			String email=(String) httpServletRequest.getSession().getAttribute("session");
			User user = userRepo.findByEmail(email);
            if (user == null) {
                httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),"Unauthorized");
            }
            chain.doFilter(httpServletRequest, httpServletResponse);
		}
		else {
			chain.doFilter(httpServletRequest, httpServletResponse);
		}
	}

}
