/**
 * �̰߳�������������������
 * wait��sleep������
 * sleep:�õ�ǰ�߳̽�������״̬���ó���ǰCPU��ִ��ʱ�䣬���ǲ��ͷ��ڸö����ϵĶ�����
 * wait:�õ�ǰ�߳̽����̵߳ȴ��أ��ó���ǰCPU��ִ��ʱ�䣬���ͷ��ڸö����ϵĶ�����
 * 			��Ҫ�����̵߳���notify��notifyAll������ȴ�ʱ�䳬ʱ�����߳����½������״̬
 * 
 * @author Administrator
 * 
 */
public class ThreadDemo8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Food food=new Food();
		new Thread(new Producter(food)).start();
		new Thread(new Consumer(food)).start();
	}

}

/**
 * ������:��ʦ
 * 
 * @author Administrator
 * 
 */
class Producter implements Runnable {

	Food food = null;

	public Producter(Food food) {
		this.food = food;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				this.food.set("������������", "�ʵ���һ��.");
			} else {
				this.food.set("��������", "��ζ��֭.");
			}
		}
	}

}

/**
 * ������:����Ա
 * 
 * @author Administrator
 * 
 */
class Consumer implements Runnable {

	Food food = null;

	public Consumer(Food food) {
		this.food = food;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			food.get();
		}
	}
}

class Food {
	private String name;
	private String content;
	
	private boolean flag=true;//true��ʾ��������,false��ʾ��������

	/**
	 * ����
	 * 
	 * @param name
	 * @param content
	 */
	public synchronized void set(String name, String content) {
		if(!flag){
			try {
				this.wait();//�õ�ǰ�߳̽���ȴ��صȴ�,û��ָ��ʱ��,
							//��Ҫ�����̻߳���,�ͷŶ�����,�ó�CPUʱ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setName(name);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setContent(content);
		
		flag=false;//��ʾ�������,��������
		this.notify();//�����ڸü������ϵ�һ���߳�
	}

	/**
	 * ����
	 */
	public synchronized void get() {
		if(flag){
			try {
				this.wait();//�õ�ǰ�߳̽��еȴ��صȴ�,û��ָ��ʱ��,
							//��Ҫ�����̻߳���,�ͷŶ�����,�ó�CPUʱ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + ":" + this.getContent());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		flag=true;//�������,����������
		this.notify();//�����ڸü������ϵ�һ���߳�
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
