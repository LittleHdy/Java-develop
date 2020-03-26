
/**
 *  �ж��߳� 
 * 1�����߳��ⲿͨ������interrupt�����ж��̣߳��̱߳���û���жϣ�ֻ������һ�����
 * ��ô��ʱ����wait,join,sleep����������InterruptedException�쳣��������жϱ�ǣ�
 * ��ʱ������Ҫ�߳��жϣ���ô��Ҫ���߳��ڲ��Լ��жϡ�
 * 2��ͨ������£��������ж��߳�ʱ���������Զ����ǵķ�ʽ����
 * ����ʹ��interrupt����
 * 
 * @author Administrator
 * 
 */
public class ThreadDemo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�жϷ�ʽ:interrupt()
		Thread t2 = new Thread(new MyThread2());
		t2.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			if (i == 5) {
				//t1.interrupt();//�ж��߳�(�����ж�״̬Ϊtrue)
				t2.interrupt();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//�Զ��巽ʽ�ж��߳�
//		MyThread my=new MyThread();
//		Thread t=new Thread(my);
//		t.start();	
//		for(int i=0;i<10;i++){
//			System.out.println(Thread.currentThread().getName() + "-" + i);
//			if(i==5){
//				my.setFlag(false);
//			}
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

}

class MyThread2 implements Runnable{

	@Override
	public void run() {
		int i=0;
		while(!Thread.interrupted()){
			System.out.println("MyThread2-" + i);
			i++;
			try {
				Thread.sleep(1000);//�ж��̺߳��ֵ���sleep()����,���ж�״̬�������,�̼߳���ִ��,���׳� InterruptedException
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();//�ٴ��жϸ��߳�,����̲߳���ִ��
			}
		}
	}
	
}

class MyThread implements Runnable {
	private Boolean flag=true;
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		int i = 0;
		while (flag) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
