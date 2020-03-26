package com.vince.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ServletAPI��ϵķ�ʽ����web��Դ 
 * 1.ͨ�� ServletActionContext
 * @author Administrator
 *
 */
public class WebResourceAction1 extends ActionSupport {
	
	public String execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("requestName", "requestName1");
		
		HttpSession session=request.getSession();
		session.setAttribute("sessionName", "sessionName1");
		
		return SUCCESS;
	}
}
