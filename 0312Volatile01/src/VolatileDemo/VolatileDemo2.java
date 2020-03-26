package VolatileDemo;

/**
 * volatile ���Զ�: ��ָֹ������
 * 
 * ָ�����Ž���:
 * �������´���
 * int i = 0;
 * int j = 1;
 * ���ܻ���ִ��int j = 1;��䣬Ҳ������������
 * 
 * @author Administrator
 *
 */
public class VolatileDemo2 {
	private static String text;
	private static volatile boolean flag = false;
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			text = "my do something";
			//����ִ�иþ����ָ��������, ����text��û�и�ֵ, �������߳����text�ǿ�
			//���˴��������ֻ������˵��������ʵ������ʱ���ѳ��֡���
			flag = true;
			
		}).start();
		
		new Thread(() -> {
			while(!flag){
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(text);
		}).start();
	}
}

class MyBus{
	private String text;
	private boolean flag = false;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}