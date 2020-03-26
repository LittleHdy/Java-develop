
/**
 * �߳� 1 ���Ȼ�õ� resource1 �ļ�������,��ʱ���߳� 2 �ͻ�ȡ�����ˡ�
 * Ȼ���߳� 1 ��ȥ��ȡ resource2 �ļ������������Ի�ȡ����Ȼ���߳� 1 �ͷ��˶� resource1��resource2 �ļ���������ռ�ã�
 * �߳� 2 ��ȡ���Ϳ���ִ���ˡ��������ƻ����ƻ�ѭ���ȴ���������˱�����������
 * @author Administrator
 *
 */
public class UnDeadLockDemo {
	private static Object resource1 = new Object();//��Դ 1
    private static Object resource2 = new Object();//��Դ 2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "�߳� 1").start();

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "�߳� 2").start();
    }
}
