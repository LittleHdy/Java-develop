
/**
 * �̷߳���: 
 * 1.�û��߳�:Ĭ������´������̶߳�Ϊ�û��߳�;�������д����û��߳�,��ô�ó������ȴ��û��߳�ִ����Ϻ����Ż���ֹ
 * 2.�ػ��߳�:���û��߳�ִ����ɺ�,�ػ��߳�Ҳ�˳�
 * 
 * @author Administrator
 * 
 */
public class ThreadDemo6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t = new Thread(new MyThread());
		t.setDaemon(true);// ����Ϊ�ػ��߳�
		t.start();
		
		Thread t2=new Thread(new MyThread2());
		t2.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Main-" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {// ע������20��,�����û��߳���10�κ����,�ػ��߳�Ҳ������
			System.out.println("MyThread-" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {// ע������20��,�����û��߳���10�κ����,�ػ��߳�Ҳ������
			System.out.println("MyThread2-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
