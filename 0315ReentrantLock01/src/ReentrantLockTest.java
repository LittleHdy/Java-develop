import java.util.concurrent.locks.ReentrantLock;

/**
 * ����Ĵ���ͨ��lock()�����Ȼ�ȡ�����Σ�Ȼ��ͨ��unlock()�����ͷ���3�Σ�������������˳�������������ӿ��Կ���,
 * ReentrantLock�ǿ����������,��һ���̻߳�ȡ��ʱ,�����Խ����ظ���ȡ��Ρ��ڼ���ReentrantLock�ĵĶ�ռ�ԣ�
 * ���ǿ��Եó�����ReentrantLock��synchronized����ͬ��
 * 
 * @author Administrator
 *
 */
public class ReentrantLockTest {

	public static void main(String[] args) {
		ReentrantLock rlock = new ReentrantLock();

		for (int i = 0; i <= 3; i++) {
			rlock.lock();
		}

		for (int i = 0; i <= 3; i++) {
			try {

			} finally {
				rlock.unlock();
			}

		}
	}
}
