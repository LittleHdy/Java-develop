package com.vince;

/**
 * final
 * 1.ʹ��final����һ������,����ֵ���ܱ��޸�,���������ʼ��(1.ֱ�Ӷ���ʱ��ֵ,2.�ڹ��췽���и�ֵ)
 * 2.ʹ��final����һ������ʱ,�÷������ܱ�������д
 * 3.ʹ��final�������಻�ܱ��̳�
 * @author Administrator
 *
 */

class Person{
	public final void eat(){
		System.out.println("person eat.");
	}
}

final class Annimal{
	
}

class Student extends Person{//,Annimal
	private final String name="abc";
	private final int age;
	public Student(){
		age=12;
	}
	
//	private void eat() {
//
//	}
}

public class TestFinal {

	
}
