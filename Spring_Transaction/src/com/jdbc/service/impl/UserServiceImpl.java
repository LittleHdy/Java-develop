package com.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jdbc.dao.UserDao;
import com.jdbc.entity.User;
import com.jdbc.service.UserService;

/**
 * Spring���������ʹ��ע��
 * 
 * Transactional:ע���ʾ�����������
 * propagation:��ʾ��������Ĵ�����ʽ,Ĭ����REQUIRED(ҵ����һ��������ִ��)
 * ����Ĭ���ύ��ʽ:�������ִ��ʱû���׳�����ʱ�쳣(RuntimeException),�������ύ,��������ع�
 * ��������rollbackFor����ָ������ع����쳣
 * Ҳ��������noRollbackFor����ָ�����񲻻ع����쳣
 * readOnly���Ա�ʾ�÷���Ϊֻ����һ�����ڲ�ѯ�ķ����У�������������ܣ�
 * timeout���Ա�ʾ�÷���ִ�еĳ�ʱʱ�䣨Ĭ��Ϊ30�룩
 * isolation������������ĸ��뼶��(һ�������ʹ�����ݿ�Ĭ�ϵķ�ʽ������Ҫ����)
 * 
 * @author Administrator
 *
 */
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * �÷������ύ,��ΪĬ�ϻع����쳣��RuntimeException,����Exception
	 */
	@Override
	public void save(User user) throws Exception  {
		userDao.save(user);
		throw new Exception("save Exception");		
	}
	
	/**
	 * �÷�����ع�,��Ϊ�޸��˻ع����쳣��Exception
	 * @param user
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	public void save2(User user) throws Exception  {
		userDao.save(user);
		throw new Exception("save Exception");		
	}

	/**
	 * �÷�����ع�,��ΪĬ�ϻع����쳣��RuntimeException
	 */
	@Override
	public void update(User user) throws SQLException {
		userDao.update(user);
		throw new RuntimeException("update exception");
	}

	/**
	 * (��Ч)�÷�����ع�,��Ϊ�޸��˻ع����쳣��Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void delete(int id) throws Exception {
		userDao.delete(id);
		//throw new Exception("delete Exception");//bug,�׳��쳣��ִ��ɾ��
	}

	/**
	 * ��ѯһ�㲻��Ҫ����
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<User> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��ѯһ�㲻��Ҫ����
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public User findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
