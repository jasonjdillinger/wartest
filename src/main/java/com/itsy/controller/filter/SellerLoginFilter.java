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

public class SellerLoginFilter implements Filter {

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

		HttpSession session = req.getSession(false);
		if (session != null) {
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		// If it was null.. create it.
		session = req.getSession();

		System.out.println("Seller from the request body: " + req.getParameter("seller"));
		System.out.println(session.getAttribute("seller"));
//			throw BusinessException("You must logout to login to another account.");

		System.out.println("Session Id: " + session.getId());

		System.out.println("Request URI is: " + req.getRequestURI());

		System.out.println("Request Method: " + req.getMethod());
		if (!(req.getMethod().equalsIgnoreCase("OPTIONS"))) {
			try {
				System.out.println("Seller Login Filtered..");
				System.out.println("Content-Type: " + req.getContentType());
				System.out.println("seller login response pre dofilter: " + res.getStatus());
				try {
					chain.doFilter(req, res);
				} catch (Exception e) {
					System.out.println("MAYBEMAYBEMAYBEMAYBEMAYBEMAYBEMAYBEMAYBENO");
					res.setStatus(401);
					return;
				}
				res.setStatus(200);
				System.out.println("seller login response post dofilter: " + res.getStatus());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Pre-flight should not happen here");
			System.out.println("Pre-flight should not happen here");
			System.out.println("Pre-flight should not happen here");
			res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
			res.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
			res.setHeader("Access-Control-Max-Age", "3600");
			res.setHeader("Content-Type", "application/json");
			res.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type");
			res.setStatus(HttpServletResponse.SC_OK);
		}
		System.out.println("Seller Login Response Status Code is: " + res.getStatus());
	}

}
