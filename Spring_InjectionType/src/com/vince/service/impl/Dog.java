package com.vince.service.impl;

import com.vince.dao.BeanDao;
import com.vince.dao.LogDao;
import com.vince.service.Animal;

public class Dog implements Animal {

	private BeanDao dao=null;
	private LogDao logDao=null;
		
	/**
	 * ������ע��,���ô˹��췽��
	 * @param logDao
	 */
	public Dog(LogDao logDao) {
		super();
		this.logDao = logDao;
	}

	/**
	 * setterע��,���ô˷���
	 * @param dao
	 */
	public void setDao(BeanDao dao) {
		this.dao = dao;
	}

	@Override
	public void call() {
		dao.add();
		logDao.insert();
		System.out.println("С����...");
	}

}
