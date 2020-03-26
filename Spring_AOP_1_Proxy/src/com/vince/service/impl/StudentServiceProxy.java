package com.vince.service.impl;

import com.vince.service.StudentService;

/**
 *  Student ������
 * @author Administrator
 *
 */
public class StudentServiceProxy implements StudentService {
	
	private StudentService target=null;//Ҫ����Ķ���
	
	public StudentServiceProxy(StudentService target){
		this.target=target;
	}

	@Override
	public void delete() {
		System.out.println("��ʼɾ��...");

		target.delete();
		
		System.out.println("����ɾ��...");
	}

}
