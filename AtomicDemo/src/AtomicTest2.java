import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * ������������ԭ���������
 * 
 * AtomicInteger ����Ҫ���� CAS (compare and swap) + volatile �� native ��������֤ԭ�Ӳ������Ӷ�����
 * synchronized �ĸ߿�����ִ��Ч�ʴ�Ϊ������
 * 
 * CAS��ԭ������������ֵ��ԭ����һ��ֵ���Ƚϣ������ͬ����³��µ�ֵ��
 * 
 * @author Administrator
 *
 */
public class AtomicTest2 {

	public static void main(String[] args) {
		print1();
		print2();
	}

	private static void print1() {
		Test1 test1 = new Test1();
		System.out.println("synchronized��ʽ�ĳ�ʼֵ:" + test1.getCount());
		for (int i = 0; i < 10; i++) {
			new Thread(new Thread1(test1)).start();
		}
		System.out.println("synchronized��ʽ�Ķ��̺߳��ֵ:" + test1.getCount());
	}

	private static void print2() {
		Test2 test2 = new Test2();
		System.out.println("atomic��ʽ�ĳ�ʼֵ:" + test2.getCount());
		for (int i = 0; i < 10; i++) {
			new Thread(new Thread2(test2)).start();
		}
		System.out.println("atomic��ʽ�Ķ��̺߳��ֵ:" + test2.getCount());
	}

}

class Thread1 implements Runnable {
	Test1 test1;

	public Thread1(Test1 test1) {
		this.test1 = test1;
	}

	@Override
	public void run() {
		test1.increment();
	}
}

class Thread2 implements Runnable {
	Test2 test2;

	public Thread2(Test2 test2) {
		this.test2 = test2;
	}

	@Override
	public void run() {
		test2.increment();
	}
}

class Test1 {
	private volatile int count = 0;

	// ��Ҫ�̰߳�ȫִ��ִ��count++����Ҫ����
	public synchronized void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}

class Test2 {
	private AtomicInteger count = new AtomicInteger(0);
	AtomicIntegerArray s = new AtomicIntegerArray(new int[]{1,2,3});
	// ʹ��AtomicInteger֮�󣬲���Ҫ������Ҳ����ʵ���̰߳�ȫ��
	public void increment() {
		count.incrementAndGet();
	}

	public int getCount() {
		return count.get();
	}
}