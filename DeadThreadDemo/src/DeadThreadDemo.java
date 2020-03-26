
/**
 * ���߳��н�����Դ����,����Ҫͬ��,����ͬ�����,�Ϳ����������
 * 
 * ģ���߳�����(��ʾ���гɹ��ĸ���,�����м��γɹ��Խϴ�)
 * @author Administrator
 *
 */
public class DeadThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DeadThread();
	}

}

class Kidnapper{
	public synchronized void say(Police p){
		System.out.println("���˵:�ȸ�Ǯ�ٷ���.");
		p.doService();
	}
	public synchronized void doService(){
		System.out.println("ͬ����,�ȷ����ٸ�Ǯ");
	}
}
class Police{
	public synchronized void say(Kidnapper k){
		System.out.println("����˵:�ȷ����ٸ�Ǯ.");
		k.doService();
	}
	public synchronized void doService(){
		System.out.println("ͬ����,�ȸ�Ǯ�ٷ���.");
	}
}

class DeadThread implements Runnable{
	Kidnapper k=new Kidnapper();
	Police p=new Police();
	public DeadThread(){
		new Thread(this).start();
		p.say(k);
	}
	public void run(){
		k.say(p);
	}
}
