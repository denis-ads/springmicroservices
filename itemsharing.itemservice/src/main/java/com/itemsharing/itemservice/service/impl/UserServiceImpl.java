package com.itemsharing.itemservice.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.stereotype.Service;

import com.itemsharing.itemservice.model.Role;
import com.itemsharing.itemservice.model.User;
import com.itemsharing.itemservice.model.UserRole;
import com.itemsharing.itemservice.repository.UserRepository;
import com.itemsharing.itemservice.service.UserService;
import com.itemsharing.itemservice.util.UserContextHolder;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	//TODO denis teste token service recuperar informaçoes do usuario logado
	//@Autowired
	//private UserInfoTokenServices userInfo;
	
	@Override
	public User findByUsername(String username) {
	    LOG.debug("ItemService.getUserByUsername Correlation id: {}", UserContextHolder.getContext().getCorrelationId());
		return userRepository.findByUsername(username);
	}
}
