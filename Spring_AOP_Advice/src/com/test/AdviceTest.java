package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.ServiceBean;

/**
 * ǰ��֪ͨ,����֪ͨ��һ��֪ͨ
 * @author Administrator
 *
 */
public class AdviceTest {

	@Test
	public void test(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		//IServiceBean sb = (IServiceBean)ctx.getBean("proxyFactoryBean");//ʵ�ֽӿ�ʱ,springʹ��Proxy��������
		ServiceBean sb = (ServiceBean)ctx.getBean("proxyFactoryBean");//��ʵ�ֽӿ�ʱ,springʹ��cglib��������
		sb.query();
		System.out.println("--------------------");
		sb.add();
		System.out.println(sb.getClass());
	}
}
