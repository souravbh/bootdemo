package com.example.controller;

import java.util.HashMap;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.example.mongoSnap.Customer;
import com.example.mongoSnap.MongoSnap;

@RestController
@RequestMapping(value="/customer")
public class BootDemoMongoController {
		
	MongoTemplate MongoTemplate;
	
	@Autowired
	private MongoSnap repository;
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public WebAsyncTask<Object> setData(@RequestParam String firstName, @RequestParam String lastName){
		
		Callable<Object> c = () ->{
			
			repository.save(new Customer(firstName, lastName));
			HashMap<String , String> hm = new HashMap<String , String>();
			hm.put("status", "200");
			return hm;
		};
		
		return new WebAsyncTask<Object>(20000,c);
	}
	
	@RequestMapping(value="/queryByFirstName", method=RequestMethod.GET)
	public WebAsyncTask<Object> queryData(@RequestParam String firstName){
		
		Callable<Object> c = () ->{
			HashMap<String , String> hm = new HashMap<String , String>();
			try{
			Customer customer = repository.findByFirstName(firstName);
			hm.put("firstName",customer.getFirstName());
			hm.put("lastName",customer.getLastName());
			}catch(Exception e){
				hm.put("status","400");
			}
			
			return hm;
		};
		
		return new WebAsyncTask<Object>(20000,c);
	}
	
	@RequestMapping(value="/AllFromDB", method=RequestMethod.GET)
	public WebAsyncTask<Object> fetchAll(){
		
		Callable<Object> c = () ->{
			
			return repository.findAll();
		};
		
		return new WebAsyncTask<Object>(20000,c);
	}
	
}
