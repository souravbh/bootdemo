package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@RestController
@RequestMapping(value="/test")
public class TestController {

	@RequestMapping(value="/accounts", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultAccounts")
    public HashMap getAccounts() throws Exception{
		int a = (int) Math.floor(Math.random() * 101);
		if(a>50)
			throw new Exception("error");
		else{
			
			HashMap hm = new HashMap();
	    	hm.put("accoutno", "1234567");
	    	return hm;
		}
		
    }
	
	@RequestMapping(value="/accounts1", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultAccounts")
    public HashMap getAccounts1() throws Exception{
		int a = (int) Math.floor(Math.random() * 101);
		if(a>30)
			throw new Exception("error");
		else{
			
			HashMap hm = new HashMap();
	    	hm.put("accoutno", "1234567");
	    	return hm;
		}
		
    }
    
	@RequestMapping(value="/accounts2", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultAccounts")
    public HashMap getAccounts2() throws Exception{
		int a = (int) Math.floor(Math.random() * 101);
		if(a>75)
			throw new Exception("error");
		else{
			
			HashMap hm = new HashMap();
	    	hm.put("accoutno", "1234567");
	    	return hm;
		}
		
    }
    
	@RequestMapping(value="/accounts3", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultAccounts")
    public HashMap getAccounts3() throws Exception{
		int a = (int) Math.floor(Math.random() * 101);
		if(a>90)
			throw new Exception("error");
		else{
			
			HashMap hm = new HashMap();
	    	hm.put("accoutno", "1234567");
	    	return hm;
		}
		
    }

    public HashMap defaultAccounts() {
    	HashMap hm = new HashMap();
    	hm.put("status", "400");
    	return hm;
    }
    
}
