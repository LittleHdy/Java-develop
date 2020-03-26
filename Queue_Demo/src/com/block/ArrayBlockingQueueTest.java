package com.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {

    static ArrayBlockingQueue<Apple> queue = new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args){
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}
}

class Apple {

}

class Producer implements Runnable {
	ArrayBlockingQueue<Apple> queue;

	public Producer(ArrayBlockingQueue<Apple> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Apple apple = new Apple();
				//��Ԫ�ز���˶��е�β��������ö�����������һֱ����
				queue.put(apple);
				System.out.println("����apple" + apple);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	ArrayBlockingQueue<Apple> queue;

	public Consumer(ArrayBlockingQueue<Apple> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while(true){
			try {
				TimeUnit.MICROSECONDS.sleep(1000);
				//��ȡ���Ƴ��˶���ͷԪ�أ���û��Ԫ����һֱ����
				Apple apple = queue.take();
				System.out.println("����Apple:" + apple);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
