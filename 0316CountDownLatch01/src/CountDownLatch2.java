import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 * ʵ�ֶ���߳̿�ʼִ�������������ԡ�ע���ǲ����ԣ����ǲ�����ǿ�����Ƕ���߳���ĳһʱ��ͬʱ��ʼִ�С�
 * ���������ܣ�������̷߳ŵ���㣬�ȴ�����ǹ�죬Ȼ��ͬʱ���ܡ�
 * �����ǳ�ʼ��һ������� CountDownLatch ���󣬽����������ʼ��Ϊ 1 ��new CountDownLatch(1) ��
 * ����߳��ڿ�ʼִ������ǰ���� coundownlatch.await()�������̵߳��� countDown() ʱ����������Ϊ0������߳�ͬʱ�����ѡ�
 * 
 * @author Administrator
 *
 */
public class CountDownLatch2 {

	static int num = 30;
	static CountDownLatch latch = new CountDownLatch(1);

	public static void main(String[] args) {
		for (int i = 1; i <= num; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						latch.await();

						System.out.println(Thread.currentThread().getName() + "��ѡ�ֿ�ʼ����.");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}

		System.out.println("����ѡ��׼������, ��ʼ����!!!");
		latch.countDown();
	}
}
