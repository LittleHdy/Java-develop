package com.bean;

public class ServiceBean {

	private DaoBean daoBean;
	
	public ServiceBean(DaoBean daoBean) {
		super();
		this.daoBean = daoBean;
		System.out.println("������ װ�� 1...");
	}
	public ServiceBean(DaoBean daoBean,DaoBean2 daoBean2) {
		super();
		this.daoBean = daoBean;
		System.out.println("������ װ��  2...");
	}
	
	public void setDaoBean(DaoBean daoBean) {
		System.out.println("setter װ��");
		this.daoBean = daoBean;
	}

	public void save(){
		daoBean.save();
		System.out.println("service saved...");
	}
}
