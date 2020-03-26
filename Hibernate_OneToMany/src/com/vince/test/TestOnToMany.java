package com.vince.test;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Article;
import com.vince.entity.User;

public class TestOnToMany {
	
	/**
	 * ������ϵӳ��-- һ�Զ�:
	 * UserΪ������,ArticleΪ�Ӷ���
	 */
	
	/**
	 * һ�Զ����:
	 * ֻ�ֶ����������ʱ,������������������[cascade="all"],����ֻ�������������ߴӶ��󱣴治�˲��׳�����쳣���ع�����[inverse="true"]�����;
	 * ����ֶ����������ʹӶ�������Ҫ����[cascade="all"]
	 * 
	 * �����ϵά��:�����������������[inverse="true"]��ʾ�ɴӶ���ά����������,���������ʱ�������޸����(user_id)�����,
	 * ��������޸����(user_id)�����
	 */
	@Test
	public void add(){
		User user=new User("С��", 23);	
		
		//Set<Article> articles=new HashSet<Article>();
		Article a1=new Article("����5","����1");
		Article a2=new Article("����6","����2");
		//articles.add(a1);
		//articles.add(a2);
		
		user.getArticles().add(a1);
		user.getArticles().add(a2);
		a1.setUser(user);
		a2.setUser(user);
		
		//ֻ�ֶ����������ʱ,������������������[cascade="all"],����Ӷ��󱣴治��,�׳�����쳣���ع�����;
		HibernateUtil.add(user);
		//��������������[ cascade="all"]ʱ�Ͳ���Ҫ�ֶ�����Ӷ���,������Ҫ�ֶ�����Ӷ���,�������
		//HibernateUtil.add(a1);
		//HibernateUtil.add(a2);
	}
	
	/**
	 * ��ѯ������:�����������������[lazy="false"]ʱ��ͬʱ��ѯ�Ӷ���,���򲻻��ѯ�Ӷ���
	 */
	@Test
	public void getUser(){
		Session session=HibernateUtil.getSession();
		User u=(User) session.get(User.class, 3);
		session.close();
		
		System.out.println(u);
		System.out.println(u.getArticles());
	}
	
	/**
	 * ��ѯ�Ӷ���:�ڴӶ������������[fetch="join"]ʱ��ͬʱ��ѯ������,���򲻻��ѯ������
	 */
	@Test
	public void getArticle(){
		Session session=HibernateUtil.getSession();
		Article a=(Article) session.get(Article.class, 3);
		
		session.close();
		
		System.out.println(a);
		System.out.println(a.getUser());
		
	}
}
