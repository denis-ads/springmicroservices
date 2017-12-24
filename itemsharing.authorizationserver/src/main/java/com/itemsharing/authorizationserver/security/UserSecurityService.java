package com.itemsharing.authorizationserver.security;

import com.itemsharing.authorizationserver.util.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itemsharing.authorizationserver.model.User;
import com.itemsharing.authorizationserver.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserSecurityService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("UserDetailsService Correlation id: {}", UserContextHolder.getContext().getCorrelationId());
		User user = userRepository.findByUsername(username);
		
		if(null == user) {
			logger.warn("UserDetailsService Username {} not found", username);
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		return user;
	}

}
