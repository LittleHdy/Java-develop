package com0302ThreadDemo;

/**
 * �߳����ݷǹ���: ��ͬʵ������������
 * @author Administrator
 *
 */
public class ThreadDemo3 {
	
	public static void main(String[] args) {
		MyThread2 a = new MyThread2("A");
		MyThread2 b = new MyThread2("B");
		MyThread2 c = new MyThread2("C");
		a.start();
		b.start();
		c.start();
	}
}

class MyThread2 extends Thread {
	
	private int count = 5;
	
	public MyThread2(String name){
		this.setName(name);
	}

	@Override
	public void run() {
		while(count > 0) {
			System.out.println("�߳�"+Thread.currentThread().getName() + ":" + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count--;
		}
	}
}