package com.vince.extendsDemo;

import java.util.Arrays;
import java.util.Collections;

/**
 * �̳�
 * 1.ֻ�����̳�
 * 2.������Լ̳и���ķ�˽�е����Ժͷ���,���췽�����ܱ��̳�
 * 3.�����ʵ��������:�ȵ��ø���Ĺ��췽��,�������û��Ĭ�ϵĹ��췽��,��ô�ӱ�����ʾ�ĵ��ø���������Ĺ��췽��
 * 4.������д:�����еķ����븸���еķ�����ͬ(��������ͬ,���������������ȫ��ͬ,����ֵ��ͬ,����Ȩ�����η����ڵ��ڸ���)
 * 		���췽�����ܱ���д
 * @author Administrator
 *
 */

class Person{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void eat(){
		System.out.println("person eat...");
	}
}
class Chinese extends Person{

	public Chinese(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void eat() {
		System.out.println("�й��˳��׷�����");
	}
}

class USA extends Person{

	public USA(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void eat() {
		System.out.println("�����˳��������");
	}
}

class USAC extends USA{

	public USAC(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
}

public class TestExtends {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Chinese c=new Chinese("aaa",21);
		c.eat();
		
		USA u=new USA("SSW",32);
		u.eat();
		
		//USAC uc = (USAC) u;//java.lang.ClassCastException�쳣
		
		byte a = 117;
		byte b = 127;
		//a = a + b;//����
		a += b;
		System.out.println(a);
		
		double d1 = 333.2d;
		//long l1 = d1;//����
		
		boolean f1 = 3 * 0.1 == 0.3;
		System.out.println(f1);//false
		
		String s1 = "aa";
		switch(s1){
		case "1":
			break;
		default:
				break;
		}
		
//		int[] ssw = {1,7,3,2};
//		Arrays.sort(ssw);
//		System.out.println(Arrays.toString(ssw));
		
	}

}
