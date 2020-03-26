package com0302ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ����̷߳��ʵ���������ͬʵ����ͬһ��ͬ������: ��ͬʵ������������
 *
 */
public class ThreadDemo1 {
	
	public static void main(String[] args) {
		PrivateNum2 p1 = new PrivateNum2();
		PrivateNum2 p2 = new PrivateNum2();
		MyThread7 t1 =  new MyThread7(p1);
		MyThread7 t2 =  new MyThread7(p2);
		t1.start();
		t2.start();
	}		
}

class MyThread7 extends Thread {
	PrivateNum2 p = null;
	public MyThread7(PrivateNum2 p){
		this.p = p;
	}
	
	@Override
	public void run() {
		p.test();
	}
}

class PrivateNum2{
	int pubNum = 10;//��Ա����, ����·���������
	public void test(){
		int num = 10;//�ֲ�����, ���̲߳����������
		while(num > 0){
			System.out.println(Thread.currentThread().getName() + ":�ֲ�����=" + num + ",��Ա����=" + pubNum);
			num--;
			pubNum--;
		}
	}
}
