package com.bean;


public class ServiceBean {

	private DaoBean daoBean;	
	
	public void setDaoBean(DaoBean daoBean) {
		System.out.println("setterװ��...");
		this.daoBean = daoBean;
	}

	public void save(){
		daoBean.save();
		System.out.println("service bean save...");
	}
}
