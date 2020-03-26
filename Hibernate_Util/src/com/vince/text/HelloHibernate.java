package com.vince.text;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Student;

public class HelloHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student("�ƻ�", "��", 24, "13298899992");
		//
		//HibernateUtil.save(stu);
		
		
		//get();
		//load();
		
		save(stu);
		//persist(stu);
		//persist2(stu);

		//update();
		//update2();
		//update3();
		
		//delete();
	}
	
	/**
	 * Hibernate ���ݶ����״̬:��ʱ״̬,�־û�״̬,����״̬
	 */
	
	/**
	 * ��ѯ:�������Ӧ�Ķ����򷵻����ݶ���,���û���򷵻�null
	 */
	private static void get(){
		Session session=HibernateUtil.GetSession();
		Student s=(Student)session.get(Student.class, 3);
		session.close();
		System.out.println(s);
	}
	
	/**
	 * ʹ��load������ѯ:���ص�ֻ�� һ������,������ȥ��ѯ���ݿ�,��ʹ�øô������ʱ�Ż�ȥ��ѯ���ݿ�;
	 * ��ʹ�øô������ʱ,����ѯ���ݿ��������򷵻����ݶ���,�����׳��쳣
	 */
	private static void load(){
		Session session=HibernateUtil.GetSession();
		Student s=(Student)session.load(Student.class,3);
		System.out.println(s);
		session.close();
	}
	
	/**
	 * ���
	 * @param s
	 */
	private static void save(Student s){
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
	}

	/**
	 * ���:persist ������Transaction��ִ��ʱ,���ݶ���(Student)���������Զ���䵽������,��save����һ��
	 * @param s
	 */
	private static void persist(Student s){
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		session.persist(s);
		tx.commit();
		session.close();
	}
	
	/**
	 * ���:persist ��������Transaction��ִ��ʱ,�ٵ��� flush������,��Ҫ�����ֵ,�������ݶ���(Student)������ӵ����ݿ�
	 * @param s
	 */
	private static void persist2(Student s){
		Session session=HibernateUtil.GetSession();
		session.persist(s);
		session.flush();
		session.close();
	}
	
	/**
	 * ͨ����ʱ���ݶ���(new��ʽ����)�޷�����
	 */
	private static void update(){
		Student s=new Student(4,"����", "��", 24, "13298899992");
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		session.update(s);
		tx.commit();
		session.close();
	}
	
	/**
	 * ͨ�����������ݿ��ѯ�õ�����,�ٸ��µ����ݿ�
	 */
	private static void update2(){
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		Student s=(Student)session.get(Student.class, 3);
		s.setName("С��");
		s.setAge(21);
		s.setPhone("45333333");
		s.setSex("��");
		session.update(s);
		tx.commit();
		session.close();
	}
	
	/**
	 * ͨ���������ļ�������[dynamic-update="true"],��ֻ����������˵�����
	 */
	private static void update3(){
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		Student s=(Student)session.get(Student.class, 4);
		s.setName("С��");
		session.update(s);
		tx.commit();
		session.close();
	}
	
	/**
	 * ɾ��:����������Ϊ�ǿ�,������������Բ���ɾ��,���ʲôֵ������
	 * �����ݿ����Ҳ���Ҫɾ���ļ�¼���׳��쳣
	 */
	private static void delete(){
		Student s=new Student();
		s.setId(11);
		s.setName("www");
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		session.delete(s);
		tx.commit();
		session.close();
	}
}
