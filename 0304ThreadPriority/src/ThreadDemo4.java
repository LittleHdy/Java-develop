

/**
 *  �̵߳����ȼ�: �̵߳����ȼ����ɿ�
 * 1�����ȼ���1��10������
 * 2�����ȼ��ߵ��̻߳�������ռCPU��ִ����Դ
 *
 */
public class ThreadDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread my=new MyThread();
		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t2.start();
		t1.start();
		
	}

}

class MyThread implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}		
	}	
}



