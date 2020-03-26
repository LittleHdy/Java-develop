import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��ȡ��ʱ��ʱ�ȴ�
 * 
 * �߳�ͨ������tryLock()������ȡ��,��һ�λ�ȡ��ʧ��ʱ������10����,Ȼ�����»�ȡ��ֱ����ȡ�ɹ����ڶ��λ�ȡʧ��ʱ,���Ȼ��ͷŵ�һ����,
 * ������10����,Ȼ������ֱ���ɹ�Ϊֹ���̻߳�ȡ�ڶ�����ʧ��ʱ�����ͷŵ�һ���������ǽ����������Ĺؼ�,�����������̷ֱ߳����һ����Ȼ���໥������һ������
 * 
 * @author Administrator
 *
 */
public class ReentrantLockTest4 {
	static Lock lock1 = new ReentrantLock();
	static Lock lock2 = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(new ThreadDemo(lock1, lock2));// ���߳��Ȼ�ȡ��1,�ٻ�ȡ��2
		Thread thread1 = new Thread(new ThreadDemo(lock2, lock1));// ���߳��Ȼ�ȡ��2,�ٻ�ȡ��1
		thread.start();
		thread1.start();
	}

	static class ThreadDemo implements Runnable {
		Lock firstLock;
		Lock secondLock;

		public ThreadDemo(Lock firstLock, Lock secondLock) {
			this.firstLock = firstLock;
			this.secondLock = secondLock;
		}

		@Override
		public void run() {
			try {
				while (!lock1.tryLock()) {
					TimeUnit.MILLISECONDS.sleep(10);
				}
				while (!lock2.tryLock()) {
					lock1.unlock();
					TimeUnit.MILLISECONDS.sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				firstLock.unlock();
				secondLock.unlock();
				System.out.println(Thread.currentThread().getName() + "��������!");
			}
		}
	}
}