package com.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * ��ע��ķ�ʽ����Bean�ı���
 * 
 * @Resourceע��ע�����,Ĭ�ϰ�����װ��,Ҳ����ָ��name��������ȷע���bean
 * 
 * @Autowiredע��,�Զ�װ��,Ĭ�ϰ�����װ��,
 * ���Ҫ������װ��,����ʹ�������ע��@Qualifier("daoBeanXXX")
 * 
 * @author Administrator
 *
 */
public class ServiceBean {

	@Resource
	private DaoBean daoBean;
	
	@Autowired
	@Qualifier("daoBean2")
	private DaoBean2 daoBean2;
	
	//@Resource(name="daoBean") //Ҳ������setter�����м�ע��
	public void setDaoBean(DaoBean daoBean) {
		System.out.println("setterװ��...");
		this.daoBean = daoBean;
	}

	public void save(){
		daoBean.save();
		daoBean2.save();
		System.out.println("service bean save...");
	}
}
