package com0307Synchronized01;
/**
 * �ڶ��̵߳Ĳ�����,����߳��п���ͬʱ����ͬһ����Դ,����Ƕ��̵߳Ĺ������� 
 * �߳�ͬ��: 
 * 1.�̲߳���ȫ:���̹߳���һ������ʱ,����������ֵ�Ĵ�����
 * 2.ʹ��ͬ����������̲߳���ȫ������
 * 	1)ͬ�������
 * 	2)ͬ������
 * 3.ͬ������Ӧ�������,�Ѱ�ȫ��û�и��ݴ����Ƴ�ͬ����
 * 4.ͬ������ͬ�����ǵ�ǰ����,��ô��ͬ������������ʱ,�ö��������ͬ�����������ȴ������� 
 * 5.ͬ�������������ܽ�������,ͬ��Խ������Խ��,�������������
 * 6.ͬ�����������������ܻ������ݰ�ȫ
 */
public class ThreadDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//method1();
		method2();
	}

	private static void method1() {
		MyThread my = new MyThread();
		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);
		t1.start();
		t2.start();
	}

	private static void method2() {
		MyThread2 my = new MyThread2();
		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);
		t1.start();
		t2.start();
	}
}

class MyThread implements Runnable {
	int num = 10;//��Ա����, ���̶߳�ͬһʵ�������Ա����
	Object obj = new Object();

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			// ͬ�������
			synchronized (obj) {
				if (num > 0) {
					System.out.println(Thread.currentThread().getName() + "--" + num);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					num--;
				}
			}
		}
	}
}

class MyThread2 implements Runnable {

	int num = 10;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			method();
		}
	}

	/**
	 * ͬ������
	 */
	public synchronized void method() {
		if (num > 0) {
			System.out.println(Thread.currentThread().getName() + "--" + num);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num--;
		}
	}
}
