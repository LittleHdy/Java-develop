package com.vince.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ServletAPI��ϵķ�ʽ����web��Դ
 * 2.ͨ��ʵ��struts�ṩ��Servlet����Aware�ӿڷ���web��Դ
 * @author Administrator
 *
 */
public class WebResourceAction2 extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	HttpServletRequest request=null;
	HttpServletResponse response=null;
	
	public String execute(){
		request.setAttribute("requestName", "WebResourceAction2.reauest");
		request.getSession().setAttribute("sessionName", "WebResourceAction2.session");
		
		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request=arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response=arg0;
	}

}
