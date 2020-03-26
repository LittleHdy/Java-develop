package com.vince.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Filter destory...");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("Filter doing...");
		HttpServletRequest request=(HttpServletRequest)arg0;
		String name=request.getParameter("name");
		if(name.equals("һ��")){
			arg2.doFilter(arg0, arg1);
		}else{
			HttpServletResponse response=(HttpServletResponse)arg1;
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("�û�������!");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter init...");
	}

}
