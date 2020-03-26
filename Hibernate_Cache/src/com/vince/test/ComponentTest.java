package com.vince.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Zoom;

/**
 * Hibernateʹ�� Ehcache ������� ���ݿ�ĸ��������Ҫ�˽�
 * 
 * @author Administrator
 *
 */

public class ComponentTest {

	@Test
	public void add() {
		Zoom z = new Zoom("�Ϻ���԰");
		HibernateUtil.add(z);
	}

	@Test
	public void getZoom() {
		Session session = HibernateUtil.getSession();
		Zoom z = (Zoom) session.get(Zoom.class, 1);
		System.out.println(z);
		session.close();

		// �����ٲ�ѯʱ�����ٲ�ѯ���ݿ���ǲ�ѯ����(�����ٷ���SQL���)
		session = HibernateUtil.getSession();
		z = (Zoom) session.get(Zoom.class, 1);
		System.out.println(z);
		session.close();
	}

	@Test
	public void GetZoomByHQL() {
		String hql = "from Zoom";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		//��Ҫ���ÿɻ��� 
		query.setCacheable(true);
		List<Zoom> list = query.list();
		for (Zoom z : list) {
			System.out.println(z);
		}
		session.close();

		session = HibernateUtil.getSession();
		query = session.createQuery(hql);
		//��Ҫ���ÿɻ��� 
		query.setCacheable(true);
		list = query.list();
		for (Zoom z : list) {
			System.out.println(z);
		}
		session.close();
	}
}
