package com.vince.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * ����
 * 
 * @author Administrator
 * 
 */
public class RefDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		try {
			ClassLoader.getSystemClassLoader().loadClass("com.vince.ref.Person");
			System.out.println("------------");
			//�������н���ó�Class.forName�������ǽ�����˳�ʼ������ClassLoader��loadClass��û�ж�����г�ʼ����ֻ�ǰ�����ص���������С�
			Class c5 = Class.forName("com.vince.ref.Person");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Person p1 = new Person("a", 12);
		Person p2 = new Person("b", 13);

		// һ��Classͨ������������ص�JVM��
		// һ��Class�������һ���ֽ���,��ͬ���͵Ķ�����ֽ�����ͬ
		// ����Class����ʽһ
		Class c1 = p1.getClass();
		Class c2 = p2.getClass();
		System.out.println(c1 == c2);
		// ����Class����ʽ��
		Class c3 = Person.class;
		System.out.println(c1 == c3);
		// ����Class����ʽ��
		Class c4 = null;
		try {
			c4 = Class.forName("com.vince.ref.Person");
			System.out.println(c2 == c4);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// ------------ͨ������Ϣʵ��������
		// �����޲������췽��(�������������Ҫ���޲����Ĺ��췽��)
		try {
			Person p3 = (Person) c4.newInstance();
			System.out.println(p3);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		// �����в�������
		Person p4 = null;
		try {
			Constructor c = c4.getConstructor(String.class, int.class);
			p4 = (Person) c.newInstance("c", 19);
			System.out.println(p4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------------��ȡ����Ϣ----------------");
		System.out.println("����:" + c4.getPackage().getName());
		System.out.println("����:" + c4.getName());
		Method[] m1 = c4.getMethods();
		for (int i = 0; i < m1.length; i++) {
			System.out.println("������:" + m1[i].getName());
		}
		System.out.println("-----------getDeclaredMethods---------");
		Method[] m2 = c4.getDeclaredMethods();
		for (int i = 0; i < m2.length; i++) {
			System.out.println("������:" + Modifier.toString(m2[i].getModifiers())
					+ " " + m2[i].getName());
		}

		System.out.println("----------��ȡ����----------");
		Field[] fs = c4.getFields();
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fs[i].getName());
		}
		System.out.println("------------------");
		Field[] fs2 = c4.getDeclaredFields();
		for (int i = 0; i < fs2.length; i++) {
			System.out.println(fs2[i].getName());
		}

		System.out.println("----------���÷���----------");
		try {
			// ���ù��з���
			Method setNameMethod = c4.getMethod("setName", String.class);
			setNameMethod.invoke(p4, "cc");// p4.setName("cc");
			System.out.println(p4);
			// ����˽�з���
			Method sayMethod = c4.getDeclaredMethod("say");
			sayMethod.setAccessible(true);// ���Լ�鷽�����η�
			sayMethod.invoke(p4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("----------��������----------");
		try {
			Field ageField = c4.getDeclaredField("age");
			ageField.setAccessible(true);//���Լ�鷽�����η�
			System.out.println(ageField.get(p4));
			ageField.set(p4, 20);
			System.out.println(p4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Person {
	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	static{
		System.out.println("Person static!!!");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	private void say() {
		System.out.println("my name is " + name);
	}

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
}