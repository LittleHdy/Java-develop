package com.unblock;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * һ���������ӽڵ���޽��̰߳�ȫ���С��˶��а��� FIFO���Ƚ��ȳ���ԭ���Ԫ�ؽ������򡣶��е�ͷ�� �Ƕ�����ʱ�����Ԫ�ء����е�β��
 * �Ƕ�����ʱ����̵�Ԫ�ء� �µ�Ԫ�ز��뵽���е�β�������л�ȡ�����Ӷ���ͷ�����Ԫ�ء�������̹߳������һ������ collection
 * ʱ��ConcurrentLinkedQueue ��һ��ǡ����ѡ�񡣴˶��в�����ʹ�� null Ԫ�ء�
 * 
 * @author Administrator
 *
 */
public class ConcurrentLinkedQueueTest {

	public static void main(String[] args) {
		// offerAndPoll();
		// peek();
		//remove();
		iterator();
	}

	private static void offerAndPoll() {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.offer("������");
		System.out.println("offer�󣬶����Ƿ�գ�" + queue.isEmpty());
		System.out.println("�Ӷ�����poll��" + queue.poll());
		System.out.println("pool�󣬶����Ƿ�գ�" + queue.isEmpty());
	}

	private static void peek() {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.offer("����");
		System.out.println("offer�󣬶����Ƿ�գ�" + queue.isEmpty());
		System.out.println("�Ӷ�����peek��" + queue.peek());
		System.out.println("�Ӷ�����peek��" + queue.peek());
		System.out.println("�Ӷ�����peek��" + queue.peek());
		System.out.println("peek�󣬶����Ƿ�գ�" + queue.isEmpty());
	}

	private static void remove() {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.offer("����");
		System.out.println("offer�󣬶����Ƿ�գ�" + queue.isEmpty());
		System.out.println("�Ӷ�����remove����Ԫ�أ�" + queue.remove("����"));
		System.out.println("�Ӷ�����remove������Ԫ�أ�" + queue.remove("123"));
		System.out.println("remove�󣬶����Ƿ�գ�" + queue.isEmpty());
	}
	
	private static void iterator(){
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.offer("3");
		queue.offer("2");
		Iterator<String> it = queue.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
