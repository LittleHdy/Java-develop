package com.vince.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Cat;
import com.vince.entity.Dog;

public class ExtendsTest {

	@Test
	public void test() {
		Cat cat=new Cat();
		cat.setName("Сè2");
		cat.setAge(2);
		cat.setCatProperty("�ÿ���è");
		
		Dog dog=new Dog();
		dog.setName("С��2");
		dog.setAge(2);
		dog.setDogProperty("�ÿ��Ĺ�");
		
		HibernateUtil.add(cat);
		HibernateUtil.add(dog);
	}

}
