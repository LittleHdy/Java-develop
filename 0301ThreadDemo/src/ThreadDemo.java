import java.util.Date;

/**
 * ����: һ���������еĳ���,ÿһ��������һ���������ڴ�ռ�
 * �߳�:�߳��ǳ�����ִ���߳�,JAVA�������������в��������ж���߳�,�����еĶ���̹߳����ڴ�ռ�
 * 
 * Ҫʵ�ֶ��̲߳���,�����ַ�ʽ:
 * 1.�̳�Thread��,��дrun����
 * 2.ʵ��Runnable�ӿ�,ʵ��run����(�Ƽ�ʹ��)
 * 
 * �̵߳�����״̬��
 * 1���ڵ�����start�������߳̽��� ����״̬
 * 2��CPU����ִ��ʱ�䲢�Ҹ��̱߳����ȣ���ô�߳̽�������״̬
 * 3���߳������й����У������߳���������ô�߳̽�������״̬��
 * 		����ʱ����������½������״̬
 * 
 * @author Administrator
 * 
 */
public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread1 t1=new MyThread1();
		t1.start();
		MyThread2 t2=new MyThread2();
		t2.start();
		
		MyRunnable myRunnable=new MyRunnable();
		Thread t3=new Thread(myRunnable);
		t3.start();
	}

}

class MyThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("MyThread1 "+i + "-" + new Date().toString());
		}
	}
}

class MyThread2 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+i + "-" + new Date().toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * �Ƽ�ʵ�ַ�ʽ
 * @author Administrator
 *
 */
class MyRunnable implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("MyRunnable "+i + "-" + new Date().toString());
		}
	}
	
}
