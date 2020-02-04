package com.itsy.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CorsFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		Filter.super.init(filterConfig);
		
		System.out.println("Filter confirgured..");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("CORS Request URI is: " + req.getRequestURI());

//		res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200"); // This isn't needed here.
		res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		res.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,observe");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Access-Control-Expose-Headers", "Authorization");
		res.addHeader("Access-Control-Expose-Headers", "responseType");
		res.addHeader("Access-Control-Expose-Headers", "observe");
		System.out.println("Request Method: " + req.getMethod());
		if (!(req.getMethod().equalsIgnoreCase("OPTIONS"))) {
			try {
				System.out.println("CORS Filtered..");
				System.out.println("Content-Type: " + req.getContentType());
				chain.doFilter(req, res);
			} catch (Exception e) {
//				e.printStackTrace();
				// E X C E P T I O N S should be handled here.. return the appropriate status code for the exceptions from your functions.
				res.setStatus(401);
			}
		} else {
			System.out.println("CORS Pre-flight");
			res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
			res.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
			res.setHeader("Access-Control-Max-Age", "3600");
			res.setHeader("Content-Type", "application/json");
	        res.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type");
			res.setStatus(HttpServletResponse.SC_OK);
		}
		System.out.println("CORS Response Status Code is: " + res.getStatus());
	}

}
