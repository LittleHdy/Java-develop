import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock��ƽ�� (ò�ƴﲻ��Ч��)
 * @author Administrator
 *
 */
public class ReentrantLockTest2 {

	static ReentrantLock lock =  new ReentrantLock(true);
	
	public static void main(String[] args) throws InterruptedException{
		for (int i = 0; i < 5; i++) {
			//Thread.sleep(1);//���Լ������߲��ܴﵽЧ��
			new Thread(new FairLock(i)).start();
			
		}
	}
	
	static class FairLock implements Runnable {
		
		int id;
		
		public FairLock(int id){
			this.id = id;
		}

		@Override
		public void run() {
			for (int i = 0; i < 2; i++) {
				lock.lock();
				System.out.println("��id:" + id);
				lock.unlock();
			}

		}
		
	}
}
