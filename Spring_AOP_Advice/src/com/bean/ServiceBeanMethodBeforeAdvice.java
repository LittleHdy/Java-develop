package com.bean;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * ǰ��֪ͨ(Advice)
 * @author Administrator
 *
 */
public class ServiceBeanMethodBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("ִ��ǰ��֪ͨ..");
		//throw new Exception("ss");
		
	}

}
