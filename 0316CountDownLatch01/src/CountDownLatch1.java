import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 * ĳһ�߳��ڿ�ʼ����ǰ�ȴ�n���߳�ִ����ϡ��� CountDownLatch �ļ�������ʼ��Ϊn ��new CountDownLatch(n)
 * ��ÿ��һ�������߳�ִ����ϣ��ͽ���������1 countdownlatch.countDown()������������ֵ��Ϊ0ʱ����CountDownLatch��
 * await() ���߳̾ͻᱻ���ѡ�һ������Ӧ�ó�����������һ������ʱ�����߳���Ҫ�ȴ�������������ϣ�֮���ټ���ִ�С�
 * 
 * @author Administrator
 *
 */
public class CountDownLatch1 {

	static int num = 30;
	static CountDownLatch latch = new CountDownLatch(num);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <= num; i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "��ѡ�ֵ����յ�.");
					latch.countDown();
				}
			}).start();
		}

		latch.await();
		System.out.println("����ѡ�ֶ������յ�, ��������!!!");
	}
}
