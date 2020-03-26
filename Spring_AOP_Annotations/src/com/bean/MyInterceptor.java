package com.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ��ע�ⷽʽ����AOP
 * @Aspect: ע���ʾ����һ����Ϊһ������
 * @Pointcut:����һ����ע��
 * ��ע����ʽ��ʽ:execution(���η� �������� ����.[..��ʾ�����Ӱ���������]��.����(����))
 *  
 * @author Administrator
 *
 */
@Aspect
public class MyInterceptor {

	//����һ����ע��
//	@Pointcut("execution(* com.service..*.*(..))")
//	private void pointcutMethod(){}
	
	/**
	 * ǰ��֪ͨ
	 */
	@Before("execution(* com.service.impl.UserServiceImpl.add())")
	public void beforeMethod(){
		System.out.println("ǰ��֪ͨ...");
	}
//	
//	/**
//	 * ����֪ͨ
//	 */
//	@AfterReturning("execution(* com.service..*.*(..))")
//	public void afterReturningMethod(){
//		System.out.println("����֪ͨ...");
//	}
//	
//	/**
//	 * ����֪ͨ
//	 */
//	@After("execution(* com.service..*.*(..))")
//	public void afterMethod(){
//		System.out.println("����֪ͨ...");
//	}
//	
//	/**
//	 * �쳣֪ͨ
//	 */
//	@AfterThrowing("execution(* com.service..*.*(..))")
//	public void throwsMethod(){
//		System.out.println("�쳣֪ͨ...");
//	}
	
	/**
	 * ����֪ͨ
	 * @param p
	 * @return
	 */
	@Around("execution(* com.service..*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint p){
		Object result=null;
		System.out.println("����֪֮ͨǰ��֪ͨ...");
		try {
			result=p.proceed();
		} catch (Throwable e) {
			//e.printStackTrace();
			System.out.println("����֪֮ͨ�쳣֪ͨ...");
		}finally{
			System.out.println("����֪֮ͨ����֪ͨ...");
		}
		System.out.println("����֪֮ͨ����֪ͨ...");
		return result;
	}
}
