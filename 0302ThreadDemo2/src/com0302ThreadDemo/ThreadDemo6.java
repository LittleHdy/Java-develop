package com0302ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * �ֲ�����������������
 * ��Ա������������
 * @author Administrator
 *
 */
public class ThreadDemo6 {
	
	public static void main(String[] args) {
		PrivateNum p = new PrivateNum();
		MyThread6 t1 =  new MyThread6(p);
		MyThread6 t2 =  new MyThread6(p);
		t1.start();
		t2.start();
	}		
}

class MyThread6 extends Thread {
	PrivateNum p = null;
	public MyThread6(PrivateNum p){
		this.p = p;
	}
	
	@Override
	public void run() {
		p.test();
	}
}

class PrivateNum{
	int pubNum = 10;//��Ա����, ���̹߳��������
	public void test(){
		int num = 10;//�ֲ�����, ���̲߳����������
		while(num > 0){
			System.out.println(Thread.currentThread().getName() + ":�ֲ�����=" + num + ",��Ա����=" + pubNum);
			num--;
			pubNum--;
		}
	}
}
