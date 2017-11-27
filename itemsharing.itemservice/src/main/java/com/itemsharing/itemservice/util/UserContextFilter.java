package com.itemsharing.itemservice.util;
import static java.util.Objects.isNull; 
import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserContextFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
		
		System.out.println("denis2");
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		
//		String correlationId = httpServletRequest.getHeader(UserContext.CORRELATION_ID);
//		if(isNull(correlationId)) {
//			correlationId = UUID.randomUUID().toString();
//		}
//		UserContextHolder.getContext().setCorrelationId(correlationId);
		
		UserContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
		UserContextHolder.getContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
		UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
		
		logger.debug("UserContextFilter Correlationid: {}", UserContextHolder.getContext().getCorrelationId());
//		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//		httpServletResponse.setHeader(UserContext.CORRELATION_ID, correlationId);
		
		filterChain.doFilter(httpServletRequest, servletResponse);
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	@Override
	public void destroy() {}
}
