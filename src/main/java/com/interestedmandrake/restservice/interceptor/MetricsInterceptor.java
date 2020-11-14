package com.interestedmandrake.restservice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.interestedmandrake.restservice.resource.MetricsResource;

@Component
public class MetricsInterceptor implements HandlerInterceptor {
	
	@Autowired
	MetricsResource metricsResource;
	
	/**
	 * increments number of hits
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
	
		MetricsResource.setNumRequests(MetricsResource.getNumRequests() + 1);
		
		return true;
	}
	
	
	
}
