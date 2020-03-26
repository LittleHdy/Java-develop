package com.vince.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Address;
import com.vince.entity.Zoom;

/**
 * �����ϵӳ��
 * @author Administrator
 *
 */

public class ComponentTest {

	@Test
	public void add() {
		Zoom z=new Zoom("��԰");
		Address addr=new Address("����·","123��");
		
		z.setAddress(addr);
		
		HibernateUtil.add(z);
	}

	@Test
	public void getZoom(){
		Zoom z=(Zoom) HibernateUtil.get(Zoom.class, 1);
		System.out.println(z);
	}
	
}
