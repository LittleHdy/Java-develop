
/**
 * �߳�����
 * ���õ�ǰ�����ͬ������ʱ,�ڷ����ڲ��ֵ��������������ͬ������,�ͻ��������
 * @author Administrator
 *
 */

public class ThreadDemo9 {
	public static void main(String[] args){
		new DeadThread();
	}
}

class DeadThread implements Runnable {
	BangFei b=new BangFei();
	GeGe g=new GeGe();
	public DeadThread(){
		new Thread(this).start();
		b.say(g);
	}

	@Override
	public void run() {
		g.say(b);
	}

}



class BangFei{
	public synchronized void say(GeGe g){
		System.out.println("����500W,����������");
		g.fun();
	}
	public synchronized void fun(){
		System.out.println("��ܷ��õ���500W");
	}
}
class GeGe{
	public synchronized void say(BangFei b){
		System.out.println("����������,����500W,");
		b.fun();
	}
	public synchronized void fun(){
		System.out.println("���ȳ�����,����500W,");
	}
}
