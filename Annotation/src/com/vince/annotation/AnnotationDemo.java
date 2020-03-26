package com.vince.annotation;

import java.lang.annotation.*;

/**
 * ע��
 * 
 * @author Administrator
 * 
 */
@MyAnnotation(name = "abc", like = { "a", "b", "c" },sex=EnumSex.G)
public class AnnotationDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("deprecation")// @SuppressWarnings ��ʾ�رղ����ı�����������Ϣ
	public static void main(String[] args) throws ClassNotFoundException {
		
		//������ע��
		Class<?> c=Class.forName("com.vince.annotation.User");
		Annotation[] annotations=c.getAnnotations();
		for(Annotation a: annotations){
			if(c.isAnnotationPresent(MyAnnotation.class)){
				MyAnnotation ma=(MyAnnotation)a;
				System.out.println(ma.name());
			}
		}
	}

	

}
@MyAnnotation(name="bb",like={"a","b","c"},sex=EnumSex.M )
class User{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "name";
	}

	@Deprecated
	public void print() {
		System.out.println("out");
	}
}

/**
 * �Զ���ע��
 * 
 * @author Administrator
 * 
 */
@Inherited//����������̳�
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})//ʹ�÷�Χ
@Retention(RetentionPolicy.RUNTIME)//Ԫע��
@interface MyAnnotation {
	public String name();

	// ����һ������,��ָ��Ĭ��ֵ
	public int age() default 10;

	// ��������
	public String[] like();
	
	//ö������
	public EnumSex sex();
}

enum EnumSex{
	M,G
}


