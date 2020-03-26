package com.vince.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.vince.dao.EmpDao;
import com.vince.entity.Emp;
import com.vince.service.EmpService;

public class EmpServiceImpl implements EmpService {

	private EmpDao empDao;
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public void add(Emp emp) throws RuntimeException {
		try {
			empDao.insert(emp);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ʧ��");
		}
	}

	@Override
	public void modify(Emp emp) throws RuntimeException {
		try {
			empDao.update(emp);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�޸�ʧ��");
		}
	}

	@Override
	public void remove(int id) throws RuntimeException {
		try {
			empDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��");
		}
	}

	@Override
	public Emp get(int id) throws RuntimeException {
		try {
			return empDao.select(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ID��ȡʧ��");
		}
	}

	@Override
	public List<Emp> list() throws RuntimeException {
		try {
			return empDao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ȡ�б�ʧ��");
		}
	}

}
