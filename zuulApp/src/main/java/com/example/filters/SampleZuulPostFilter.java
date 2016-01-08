package com.example.filters;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class SampleZuulPostFilter extends ZuulFilter{

	
	@Override
	public Object run() {

		System.out.println("Executed Zuul post filter for uri::"+ RequestContext.getCurrentContext().getRequest().getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	
}
