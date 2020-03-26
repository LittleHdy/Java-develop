package com.vince.struts;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ServletAPI����ķ�ʽ����web��Դ
 * 1.ͨ��ActionContext��ʽ����
 * @author Administrator
 *
 */
public class WebResourceAction3 extends ActionSupport {
	
	
	public String execute(){
		
		//��ȡ��ǰ�����ActionContext����
		ActionContext ctx=ActionContext.getContext();
		//��ͬ��ServletContext����
		Map<String,Object> application=ctx.getApplication();
		//��ͬ��HttpSession
		Map<String,Object> session=ctx.getSession();
		
		Map<String,Object> request=(Map<String,Object>)ctx.get("request");
		
		request.put("requestName", "WebResourceAction3.request");
		session.put("sessionName", "WebResourceAction3.session");
		
		return SUCCESS;
	}
}
