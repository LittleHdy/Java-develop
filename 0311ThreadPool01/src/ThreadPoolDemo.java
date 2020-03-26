import java.util.concurrent.*;


public class ThreadPoolDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����һ�����̵߳��̳߳�
		//ExecutorService se=Executors.newSingleThreadExecutor();
		
		//����һ���̶���С���̳߳�
		//ExecutorService se=Executors.newFixedThreadPool(2);
		
		//����һ���ɻ�����̳߳�
		//ExecutorService se=Executors.newCachedThreadPool();
		
		//����һ����С�����Ƶ��̳߳�
		ExecutorService se=Executors.newScheduledThreadPool(2);
		MyThread my=new MyThread();
		MyThread my2=new MyThread();
		se.execute(my);
		se.execute(my2);
	}

}

class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName() + "-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}