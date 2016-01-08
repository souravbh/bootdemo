package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan
public class ZuulAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulAppApplication.class, args);
	}
}
