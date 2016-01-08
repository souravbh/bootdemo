package com.example.controller;

import java.util.HashMap;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.example.configModel.DemoConfigModel;

@RestController
@RequestMapping(value="/demo")
public class BootDemoController {

	@Autowired
	public DemoConfigModel demoConfigModel;
	
	@Autowired
	DiscoveryClient client;
	
	@RequestMapping(value="/getPayee", method=RequestMethod.GET)
	public WebAsyncTask<Object> getPayee(){
		
		Callable<Object> c = () ->{
			
			HashMap<String , String> hm = new HashMap<String , String>();
			hm.put(demoConfigModel.getPayeeNameLabel(), "Sourav Bhattacharya");
			hm.put(demoConfigModel.getPayeeTypeLabel(),"Checking");
			return hm;
		};
		
		return new WebAsyncTask<Object>(20000,c);
	}
	
	@RequestMapping(value="/addPayee", method=RequestMethod.GET)
	public HashMap addPayee(){
		
		
		ServiceInstance localInstance = client.getLocalServiceInstance();
		HashMap hm = new HashMap();
		hm.put("key", "1");
		hm.put("val","one");
		hm.put("unique", localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort());
		return hm;
		
	}
}
