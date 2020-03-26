package com.unblock;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �Ƚ�size()��isEmpty() Ч�ʵ�ʾ����
 * 
 * ������10000����ȥ����Է���10�����ӹ������ֱ�Ƚ�size() �� isEmpty() �ĺ�ʱ
 * 
 * @author Administrator
 *
 */
public class ConcurrentLinkedQueueTest2 {

	public static void main(String[] args) throws InterruptedException {
		int peopleNum = 10000;// �Է�����
		int tableNum = 10;// ��������

		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		CountDownLatch count = new CountDownLatch(tableNum);// ������

		// ���Է�����������У��Է����˽����Ŷӣ�
		for (int i = 1; i <= peopleNum; i++) {
			queue.offer("������_" + i);
		}
		// ִ��10���̴߳Ӷ���ȡ��Ԫ�أ�10�����ӿ�ʼ������
		System.out.println("-----------------------------------������-----------------------------------");
		long start = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(tableNum);
		for (int i = 0; i < tableNum; i++) {
			executorService.submit(new Dinner("00" + (i + 1), queue, count));
		}
		// �������ȴ���֪������Ϊ�գ������˳��꣩
		count.await();
		long time = System.currentTimeMillis() - start;
		System.out.println("-----------------------------------�������Ѿ�����-----------------------------------");
		System.out.println("����ʱ��" + time);
		// ֹͣ�̳߳�
		executorService.shutdown();
	}

	private static class Dinner implements Runnable {
		private String name;
		private ConcurrentLinkedQueue<String> queue;
		private CountDownLatch count;

		public Dinner(String name, ConcurrentLinkedQueue<String> queue, CountDownLatch count) {
			this.name = name;
			this.queue = queue;
			this.count = count;
		}

		@Override
		public void run() {
			// while (queue.size() > 0){
			while (!queue.isEmpty()) {
				// �Ӷ���ȡ��һ��Ԫ�� �Ŷӵ�����һ��
				System.out.println("��" + queue.poll() + "��----�ѳ���...�� ������ţ�" + name);
			}
			count.countDown();// ������-1
		}
	}
}
