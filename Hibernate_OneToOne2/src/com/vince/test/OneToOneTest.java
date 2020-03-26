package com.vince.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.IdCard;
import com.vince.entity.Person;

/**
 * ������ϵӳ��-һ��һӳ��֮���ӳ��
 * @author Administrator
 *
 */

public class OneToOneTest {

	@Test
	public void add() {
		Person p=new Person("С��",22);
		IdCard card=new IdCard("123467890");
		
		p.setIdCard(card);
		card.setPerson(p);
		
		HibernateUtil.add(p);
	}

	@Test
	public void getPerson(){
		Person t=(Person) HibernateUtil.get(Person.class, 2);
		System.out.println(t);
	}
	
	@Test
	public void getIdCard(){
		IdCard c=(IdCard) HibernateUtil.get(IdCard.class, 2);
		System.out.println(c);
	}
}
