package com.itemsharing.authorizationserver;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAuthorizationServer
@EnableEurekaClient
@EnableResourceServer
@ComponentScan(basePackages = {"com.itemsharing.authorizationserver"})
//@EnableJpaRepositories
public class AuthorizationserverApplication {

	//spring.sleuth.sampler.percentage .5
	@Bean
	public Sampler defaultSampler() {
		return new AlwaysSampler();
	}

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }
    

	@RequestMapping(value = "/user", produces = "application/json")
	public Map<String, Object> user (OAuth2Authentication user) {
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", user.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		
		return userInfo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationserverApplication.class, args);
	}
}
