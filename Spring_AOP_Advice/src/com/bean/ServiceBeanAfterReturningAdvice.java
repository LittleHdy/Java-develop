package com.bean;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * ����֪ͨ 
 * @author Administrator
 *
 */
public class ServiceBeanAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("ִ�к���֪ͨ...");
		
	}

}
