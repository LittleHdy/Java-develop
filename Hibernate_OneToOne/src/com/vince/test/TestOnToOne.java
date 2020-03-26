package com.vince.test;


import org.hibernate.Session;
import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.IdCard;
import com.vince.entity.Person;

public class TestOnToOne {
	
	/**
	 * ������ϵӳ��-- һ��һ����������ʽ:
	 * PersonΪ������,IdCardΪ�Ӷ���,�Ӷ���id�ο��������id,���Ӷ����id���������idһ��
	 */
	
	@Test
	public void add(){
		Person p=new Person("С��", 23);		
		IdCard idCard=new IdCard("12345678990");
		
		p.setIdCard(idCard);
		idCard.setPerson(p);
		
		HibernateUtil.add(p);
		//��������������[ cascade="all"]ʱ�Ͳ���Ҫ�ֶ�����Ӷ���,������Ҫ�ֶ�����Ӷ���,�������
		//HibernateUtil.add(idCard);
	}
	
	@Test
	public void getPerson(){
		Session session=HibernateUtil.getSession();
		//һ��һ����ʱ,����ѯ������Person��ͬʱʹ��join��ѯ�Ӷ���IdCard
		Person p=(Person) session.get(Person.class, 3);
		session.close();
		//����һ���ѯ���
		System.out.println(p);
		//�����ٷ��Ͳ�ѯ���
		System.out.println(p.getIdCard());
	}
	
	@Test
	public void getIdCard(){
		Session session=HibernateUtil.getSession();
		//һ��һ����ʱ,����ѯ�Ӷ���IdCardʱ����ͬʱ��ѯ������Person
		IdCard c=(IdCard) session.get(IdCard.class, 3);
		
		//����һ���ѯ���
		System.out.println(c);
		//���ٷ��Ͳ�ѯ���
		System.out.println(c.getPerson());
		
		session.close();
	}
}
