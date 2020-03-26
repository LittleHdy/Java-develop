package com.vince.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * ��ʡ����
 * 
 * @author Administrator
 * 
 */
public class IntrospectorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog=DogFactory.createDog("dog");
		System.out.println(dog);
	}

}

class DogFactory {
	private static Properties config = new Properties();

	static {
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("bean.properties");
		try {
			config.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Dog createDog(String name) {
		try {
			String className = config.getProperty(name);
			//ͨ�������ȡClass
			Class c = Class.forName(className);
			Dog dog = (Dog) c.newInstance();

			// ��ʡ
			BeanInfo beanInfo = Introspector.getBeanInfo(c);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < pds.length; i++) {
				if ("name".equals(pds[i].getName())) {
					String nameValue=config.getProperty("dog.name");
					//ͨ��������������ȡ�����Ե�д��������(set����)
					Method m = pds[i].getWriteMethod();
					m.invoke(dog, nameValue);
				}else if ("age".equals(pds[i].getName())) {
					String ageValue=config.getProperty("dog.age");
					//ͨ��������������ȡ�����Ե�д��������(set����)
					Method m = pds[i].getWriteMethod();
					m.invoke(dog, Integer.parseInt(ageValue));
				}
			}
			
			return dog;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

class Dog {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
}