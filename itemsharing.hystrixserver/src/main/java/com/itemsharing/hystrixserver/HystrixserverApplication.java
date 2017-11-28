package com.itemsharing.hystrixserver;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
@EnableHystrixDashboard
@EnableRabbit
public class HystrixserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixserverApplication.class, args);
	}
}
