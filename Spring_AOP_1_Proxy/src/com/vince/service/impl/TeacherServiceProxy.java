package com.vince.service.impl;

import com.vince.service.TeacherService;

/**
 * teacher ������
 * @author Administrator
 *
 */
public class TeacherServiceProxy implements TeacherService {
	
	private TeacherService target=null;//Ҫ�����Ŀ�����
	
	public TeacherServiceProxy(TeacherService target){
		this.target=target;
	}

	@Override
	public void delete() {
		System.out.println("��ʼɾ��...");

		target.delete();
		
		System.out.println("����ɾ��...");
	}

}
