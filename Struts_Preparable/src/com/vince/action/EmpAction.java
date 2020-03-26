package com.vince.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.vince.dao.impl.EmpDaoImpl;
import com.vince.entity.Emp;

/**
 * Prepareable������
 * 1.��ִ�о����ҵ�񷽷�֮ǰ��������Ϊ����׼������
 * 2.ʹ�ø�������Ϊÿ�������ҵ�񷽷�дһ��׼������ķ���,������Ϊprepare��prepareDoǰ׺���Ͼ����ҵ�񷽷���,������ĸ��д
 * 3.��struts.xml�ļ�������ʹ��paramsPrepareParamsStack������ջ,Ŀ����Ϊ��ִ��׼��֮ǰ��ִ��param������Ϊջ������ֵ
 * paramsPrepareParamsStack��������ִ��˳���ǣ�
 * parmas-->prepare-->modelDriven-->params
 * @author Administrator
 *
 */
public class EmpAction extends ActionSupport implements RequestAware,ModelDriven<Emp>,Preparable {

	private Emp emp;
	private int id;
	
	private Map<String,Object> request;
	private EmpDaoImpl dao=new EmpDaoImpl();
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String list(){
		List<Emp> list=dao.list();
		request.put("emps", list);
		return "list";
	}
	
	/**
	 * Ϊ��ȡ����׼������
	 */
	public void prepareGet(){
		System.out.println("prepareGet...");
		emp=dao.get(id);
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
		emp=new Emp();
	}
	public String add(){
		dao.add(emp);
		return "list-action";
	}
	
	/**
	 * Ϊ�޸ķ���׼������
	 */
	public void prepareUpdate(){
		System.out.println("prepareUpdate...");
		emp=new Emp();
	}
	public String update(){
		dao.update(emp);
		return "list-action";
	}
	
	public String delete(){
		dao.delete(id);
		return "list-action";
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
	}
	
	/**
	 * ModelDrivern�ӿڵķ���
	 */
	@Override
	public Emp getModel() {
		//System.out.println("getModel...");
		//emp=new Emp();
		return emp;
	}
	
	/**
	 * Preparable�ӿڵķ���
	 */
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
