package VolatileDemo;

/**
 * volatile ��ʵ��: �ڴ�����
 * 
 * �ڴ��������������ã�
 * ��1����ֹ���������ָ��������
 * ��2��ǿ�ư�д������/���ٻ����е����ݻ�д�����ڴ棬�û�������Ӧ������ʧЧ��
 * 
 * @author Administrator
 *
 */
public class VolatileDemo3 {
	// a��ʹ��volatile����
	public static long a = 0;
	// ���������е�Ӱ��
	public static long p1, p2, p3, p4, p5, p6, p7;
	// bʹ��volatile����
	public static volatile long b = 0;
	// ���������е�Ӱ��
	public static long q1, q2, q3, q4, q5, q6, q7;
	// c��ʹ��volatile����
	public static long c = 0;

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			while (a == 0) {
				long x = b;
			}
			System.out.println("a=" + a);
		}).start();

		new Thread(() -> {
			while (c == 0) {
				long x = b;
			}
			System.out.println("c=" + c);
		}).start();

		Thread.sleep(1000);

		a = 1;
		b = 1;
		c = 1;
	}
}