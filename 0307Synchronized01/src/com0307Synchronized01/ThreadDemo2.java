package com0307Synchronized01;

/**
 * synchronized �ǿ�������: һ����õ������߳�ûִ������Լ��������
 * �߳�ռ������ʱ�����ִ�е�ͬ�������쳣���Ὣ���ó�
 * @author Administrator
 *
 */
public class ThreadDemo2 {

	public static void main(String[] args) {
		Service s = new Service();
		MyThread6 t =  new MyThread6(s);
		t.start();
	}
	
}

class MyThread6 extends Thread{
	Service s;
	public MyThread6(Service s){
		this.s = s;
	}
	
	@Override
	public void run() {
		s.service1();
	}
}

class Service{
	public synchronized void service1(){
		System.out.println("����1");
		service2();
	}
	
	public synchronized void service2(){
		System.out.println("����2");
		service3();
	}
	
	public synchronized void service3(){
		System.out.println("����3");
	}
}
