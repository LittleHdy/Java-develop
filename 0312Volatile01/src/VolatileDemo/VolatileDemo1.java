package VolatileDemo;

/**
 * https://www.cnblogs.com/tong-yuan/p/volatile.html
 * 
 * volatile����һ: �ɼ���--��һ���߳��޸��˹��������ֵ�������߳���������֪�����ֱ仯
 * 
 * ���������,���finished������ʹ��volatile����ʱ����������������������ʹ��volatile����ʱ���������Զ�������
 * 
 * ��Ϊ��ʹ��volatile����ʱ��checkFinished()���ڵ��߳�ÿ�ζ��Ƕ�ȡ�����Լ������ڴ��еı�����ֵ�����ֵһֱΪ0������һֱ����������whileѭ����
 * ʹ��volatile����ʱ��checkFinished()���ڵ��߳�ÿ�ζ��Ǵ����ڴ��м������µ�ֵ����finished�����߳��޸�Ϊ1��ʱ������������֪��������������whileѭ����
 * 
 * @author Administrator
 *
 */
public class VolatileDemo1 {

	//private static boolean finished = false;
	private static volatile boolean finished = false;
	
	private static void checkFinish(){
		while(!finished){
			//do smoething
		}
		System.out.println("���߳̽���");
	}
	
	private static void finish(){
		finished = true;
	}
	
	public static void main(String[] args) throws InterruptedException {
		//��һ���̼߳���Ƿ����
		new Thread(() -> checkFinish()).start();
		
		Thread.sleep(1000);//��˯�ߵĻ���ʹ��volatileҲ���Խ������߳�
		
		//���ý�����־
		new Thread(() -> finish()).start();
		
		System.out.println("���߳̽���");
	}
}
