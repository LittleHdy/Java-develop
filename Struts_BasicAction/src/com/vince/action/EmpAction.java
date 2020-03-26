package com.vince.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.vince.base.BasicAction;
import com.vince.dao.impl.EmpDaoImpl;
import com.vince.entity.Emp;

/**
 *
 */
public class EmpAction extends BasicAction<Emp> {
	
	private EmpDaoImpl dao=new EmpDaoImpl();
		
	public String list(){
		List<Emp> list=dao.list();
		request.put("emps", list);
		return "list";
	}
	
	/**
	 * Ϊ��ȡ����׼������
	 */
	public void prepareGet(){
		System.out.println("prepareGet..."+id);
		model=dao.get(id);
	}
	public String get(){
		return "update";
	}
	
	public String doAdd(){
		return "doAdd";
	}	
	/**
	 * Ϊ��ӷ���׼������
	 */
	public void prepareAdd(){
		System.out.println("prepareAdd...");
		model=new Emp();
	}
	public String add(){
		dao.add(model);
		return "list-action";
	}
	
	/**
	 * Ϊ�޸ķ���׼������
	 */
	public void prepareUpdate(){
		System.out.println("prepareUpdate...");
		model=new Emp();
	}
	public String update(){
		dao.update(model);
		return "list-action";
	}
	
	public String delete(){
		dao.delete(id);
		return "list-action";
	}
}
