
/**
 * �߳�����
 * 
 * �߳� A ͨ�� synchronized (resource1) ��� resource1 �ļ���������Ȼ��ͨ�� Thread.sleep(1000);
 * ���߳� A ���� 1s Ϊ�������߳� B �õ�ִ��Ȼ���ȡ�� resource2 �ļ���������
 * �߳� A ���߳� B ���߽����˶���ʼ��ͼ�����ȡ�Է�����Դ��Ȼ���������߳̾ͻ����뻥��ȴ���״̬����Ҳ�Ͳ�������������������ӷ��ϲ����������ĸ���Ҫ������

ѧ������ϵͳ�����Ѷ�֪��������������߱������ĸ�������

��������������Դ����һ��ʱ��ֻ��һ���߳�ռ�á�
�����뱣��������һ��������������Դ������ʱ�����ѻ�õ���Դ���ֲ��š�
����������:�߳��ѻ�õ���Դ��ĩʹ����֮ǰ���ܱ������߳�ǿ�а��ᣬֻ���Լ�ʹ����Ϻ���ͷ���Դ��
ѭ���ȴ�����:���ɽ���֮���γ�һ��ͷβ��ӵ�ѭ���ȴ���Դ��ϵ��
 * @author Administrator
 *
 */
public class DeadLockDemo {
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
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "�߳� 2").start();
    }
}
