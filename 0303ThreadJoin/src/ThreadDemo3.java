
/**
 * join ʹ��
 * @author Administrator
 *
 */
public class ThreadDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread());
		t1.start();

		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			try {
				if (i == 5) {
					t1.join();//�ȴ�t1�߳�ִ�����,���߳��ټ���ִ��
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
