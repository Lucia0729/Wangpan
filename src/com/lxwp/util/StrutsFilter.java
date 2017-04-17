package com.lxwp.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class StrutsFilter extends StrutsPrepareAndExecuteFilter {

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httprequest=(HttpServletRequest) request;
		String url=httprequest.getRequestURI();
		if(url.contains(".do")){
			chain.doFilter(request, reponse);
		}else{
			super.doFilter(request, reponse, chain);
		}
	}
}
