package com.vince.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��̬��������
 * @author Administrator
 *
 */
public class JDKDyncProxyFactory implements InvocationHandler {
	
	private Object target=null;

	public Object createProxyInstance(Object target){
		this.target=target;
		//JDK�ṩProxy����������̬�������
		//����(Ŀ�����������������,Ŀ�����ʵ�ֵĽӿ�)
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("��ʼ����...");
		
		//���ñ��������ķ���
		Object result=method.invoke(target, args);
		
		System.out.println("��������...");
		return result;
	}
}
