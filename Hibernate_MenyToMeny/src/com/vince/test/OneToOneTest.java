package com.vince.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Student;
import com.vince.entity.Teacher;

/**
 * ������ϵӳ��-��Զ�
 * @author Administrator
 *
 */
public class OneToOneTest {

	@Test
	public void add() {
		Teacher t1=new Teacher("����ʦ",22);
		Student s1=new Student("��ͬѧ");
		Student s2=new Student("��ͬѧ");
		
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		
		HibernateUtil.add(t1);
	}
	
	@Test
	public void getTeacher() {
		Teacher t1=(Teacher) HibernateUtil.get(Teacher.class, 2);
		System.out.println(t1);
	}
}
