package com.itemsharing.userservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
