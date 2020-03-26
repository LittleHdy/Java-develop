package com.vince.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet��������: servletʵ����web��������(tomcat),init������ÿһ������ʱִ����ִֻ��һ��,
 * �Ժ�ÿ������ʱ����ִ��init����,����ִ��service����,destory�����ڹر�web����ʱִ��
 * 
 * ��Ҫ�����̰߳�ȫ������
 * 1.���ʳ�Ա����ʱ
 * 2.���ʹ�����Դʱ
 * 
 * Servlet ���̲߳���ȫ��,�������:
 * 1.servletʵ��SingleThreadModel�ӿ�(�ѹ�ʱ,���������servletʵ��)
 * 2.ʹ��ͬ������� synchronized(������)
 * 3.��ʹ��SingleThreadModelҲ��ʹ��synchronize,ͬʱ��ʹ�ó�Ա�����͹�����Դ(�Ƽ�)
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet implements SingleThreadModel {
	private static final long serialVersionUID = 1L;
       
	private static int count=0;//��servlet�ж����Ա����,��Ҫ�����̰߳�ȫ����
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void text(){
		synchronized(this){
			count++;
		}
	}
}
