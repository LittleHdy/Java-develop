package com.vince.service.impl;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyFactory {

	public Object createProxyInstance(final Object target){
		Enhancer enhancer=new Enhancer(); 
		
		//ָ��Ŀ�������Ϊ�������ĸ���
		enhancer.setSuperclass(target.getClass());
		//����ص�����
		Callback callback=new MethodInterceptor() {
			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2,
					MethodProxy arg3) throws Throwable {
				System.out.println("cglib proxy begin...");
				
				Object result = arg1.invoke(target, arg2);
				
				System.out.println("cglib proxy end...");
				
				return result;
			}
		};
		//���ûص�����
		enhancer.setCallback(callback);
		//����������󲢷���
		return enhancer.create();
	}
}
