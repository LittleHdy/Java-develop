package com.bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ����֪ͨ
 * @author Administrator
 *
 */
public class ServiceBeanMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result=null;
		System.out.println("����֪֮ͨǰ��֪ͨ...");
		
		try {
			result = invocation.proceed();
		} catch (Exception e) {
			System.out.println("����֪֮ͨ�쳣֪ͨ...");
		}finally{
			System.out.println("����֪֮ͨ����֪ͨ...");
		}
		System.out.println("����֪֮ͨ����֪ͨ...");
		return result;
	}

}
