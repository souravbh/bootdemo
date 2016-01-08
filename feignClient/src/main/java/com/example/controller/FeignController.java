package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

@Component
@RestController

@RequestMapping("/hello")
public class FeignController {
	
	@Autowired
	FeignWrapper feignWrapper;
	
	@RequestMapping(value="/world", method=RequestMethod.GET)
	public HashMap addPayee() {
		
		return feignWrapper.addPayee();
	}

}
