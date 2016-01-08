package com.example.controller;

import java.util.HashMap;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("bootdemo")
public interface FeignWrapper {

	@RequestMapping(value="/demo/addPayee", method=RequestMethod.GET)
	HashMap addPayee();
	}
	
