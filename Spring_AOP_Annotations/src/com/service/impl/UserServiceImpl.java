package com.service.impl;

import com.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void query() {
		System.out.println("��ѯ�û�...");
		
	}

	@Override
	public void add() throws RuntimeException {
		System.out.println("����û�...");
		throw new RuntimeException("�����쳣");
	}

	@Override
	public void update() {
		System.out.println("�����û�...");
	}

}
