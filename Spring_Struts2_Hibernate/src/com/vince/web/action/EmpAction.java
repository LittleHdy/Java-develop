package com.vince.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.vince.entity.Emp;
import com.vince.service.EmpService;

public class EmpAction extends ActionSupport implements RequestAware,ModelDriven<Emp>,Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Emp emp;
	private EmpService empService;
	private Map<String, Object> request;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	public String list(){
		try {
			List<Emp> list=empService.list();
			request.put("emps", list);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return ERROR;
		}
		return "list-success";
	}
	
	public String doAdd(){
		return "add";
	}
	/**
	 * Ϊ��ӷ���׼������(����prepare������ִ��ʱ������)
	 */
	public void prepareAdd(){
		emp=new Emp();
	}
	public String add(){
		try {
			empService.add(emp);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return ERROR;
		}
		return "list";
	}
	
	/**
	 * ��prepare������ִ��ʱ��ѯ����
	 */
	public void prepareFindById(){
		try {
			emp = empService.get(id);System.out.println(id);System.out.println(emp);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	//����ID��ѯһ��Ա����Ϣ����
	public String findById(){
		return "modify";
	}
	
	/**
	 * Ϊ���·���׼������(����prepare������ִ��ʱ������)
	 */
	public void prepareModify(){
		emp=new Emp();
	}
	public String modify(){
		try {
			System.out.println(emp);
			empService.modify(emp);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return ERROR;
		}
		return "list";
	}
	
	public String delete(){
		try {
			empService.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return ERROR;
		}
		return "list";
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;		
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Emp getModel() {
		return emp ;
	}
}
