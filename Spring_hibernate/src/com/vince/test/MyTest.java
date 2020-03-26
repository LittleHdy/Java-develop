package com.vince.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vince.dao.UserDao;
import com.vince.entity.User;

/**
 * ����ʱ���ܲ���junit��ʽ,���Ҳ���User.hbm.xml�ļ�
 * 
 * Spring����Hibernate
 * һ.������jar��
 * 	1.����spring jar��
 * 		AOP����
 * 			aspectjrt.jar
 * 			aspectjweaver.jar
 * 			cglib-nodep-2.1_3.jar
 * 		���İ�:spring.jar
 * 		ע��:common-annotations.jar
 * 		��־:
 * 			commons-logging.jar
 * 			slf4j-api-1.5.0.jar
 * 			slf4j-log4j12-1.5.0.jar
 * 			log4j-1.2.15.jar
 * 		���ӳ�dbcp:
 * 			commons-dbcp.jar
 * 			commons-pool.jar
 * 		Hibernate3֧�ְ�:
 * 			hibernate-annotations.jar
 * 			hibernate-commons-annotations.jar
 * 			hibernate-entitymanager.jar
 * 
 * 	2.����hibernate3 jar��
 * 		hibernate���İ�:
 * 			jta-1.1.jar
 * 			commons-collections-3.1.jar
 * 			hibernate3.jar
 * 			antlr-2.7.6.jar
 * 			javassist-3.12.0.GA.jar
 * 			dom4j-1.6.1.jar
 * 		jpa֧��:hibernate-jpa-2.0-api-1.0.0.Final.jar
 * 
 * 	3.���ݿ�������:mysql-connector-java-5.1.23-bin.jar
 * 
 * ��.����ʵ����:
 * 		User��
 * 
 * �� .����ʵ�����ӳ���ļ� User.hbm.xml
 * 
 * ��.��Spring�����ļ�������
 * 		1.���ö�ȡ���ݿ����������Ϣ�ļ�classpath�µ�db.properties�ļ�
 * 		2.�������ݿ�ԴdataSource(����ʹ��dbcp���ӳ�)
 * 		3.����spring�ṩ��sessionFactoryBean
 * 			(1)sessionFactory�󶨵�����Դ
 * 			(2)hibernateӳ���ļ�
 * 			(3)hibernate���������
 * 			ע:���ʹ��hibernate.cfg.xml�������ÿ�ʡ������3��,ֱ��ʹ��configLocation����ָ��hibernate.cfg.xml��λ��
 * 
 * ��.����HibernateTempalte bean,ͨ��������ע��sessionFactory bean
 * 
 * ��.����Dao�ӿڼ���ʵ����
 * 	ͨ��ע��HibernateTemplate������������ݿ�
 * 
 * ��.��д����
 * 			
 * 
 * @author Administrator
 *
 */
public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//insert();
//		update();
//		delete();
//		get();
		list();
	}
	
	public static void insert(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		User user = new User("С��", 23);
		dao.insert(user);
	}
	
	public static void update(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		User user = new User(11,"С��", 21);
		dao.update(user);
	}
	
	public static void delete(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		dao.delete(13);
	}
	
	public static void get(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		User user=dao.get(12);
		System.out.println(user);
	}
	
	public static void list(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		List<User> list=dao.list();
		for (User user : list) {
			System.out.println(user);
		}		
	}
}
