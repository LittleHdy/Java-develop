import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ListDemo {

	public static void main(String[] args) {
		arrayList();
		System.out.println("-------------------------------");
		linkedList();
		System.out.println("-------------------------------");
		vector();
		System.out.println("-------------------------------");
		copyOnWriteArrayList();
	}

	/**
	 * ArrayList:
	 * 1��ArrayList�ڲ�ʵ�ֲ���Object��������
	 * 2��Ĭ�ϳ�ʼ����Ϊ10����������Ĵ�С��
	 * 3������Ӷ���ʱ���������С����ô���ö�������������䣨�����㷨����ǰ������һ�룩
	 * 4��ArrayListɾ���������Ч�ʵͣ�ԭ����Ҫ�ƶ�����Ԫ�أ�
	 * 5���ô������ҷ��㣬������
	 * 6������洢��Ԫ�ظ�������ȷ����ô�����ڹ���ArrayListʱʹ�ô���ʼ�����Ĺ�����
	 * 7����ͬһ��List���󼯺��У�ͨ�����ֻ����һ�����͵Ķ���
	 * 		jdk1.5�����������϶���ʱ��ʹ�÷���Լ�����ϵĴ洢����
	 * 8��ArrayList���̲߳���ȫ�ģ�Ч�ʸ�
	 * 9��jdk1.2��ʼ
	 * 
	 */
	public static void arrayList() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("11");
		list.add("bb");
		System.out.println(list.size());
		for (String string : list) {
			System.out.print(" " + string);
		}
	}
	
	/**
	 * LinkedList��
	 * 1��ʹ���������ݽṹʵ��
	 * 2���ü��Ͼ߱�����������ŵ�(���룬ɾ����)
	 * 3��LinkedListʵ����queue���нӿڣ�������Ϊ�������ݽṹʹ��
	 * 
	 */
	public static void linkedList(){
		List<String> list=new LinkedList<String>();
		list.add("aa");
		list.add("bb");
		list.add("aa");
		System.out.println(list.size());
		for (String string : list) {
			System.out.print(" " + string);
		}
		//��Ϊ����ʹ��
		Queue<String> queue=new LinkedList<String>();
		queue.add("cc");
		queue.add("dd");
		queue.add("22");
		queue.poll();////�Ӷ����л�ȡ���Ƴ�����ͷ
		System.out.println("\n��ǰ���е�ͷ�ǣ�"+queue.element());
	}
	
	
	/**
	 * Vector:
	 * ��ArrayList����ʵ��ԭ����ͬ
	 * �̰߳�ȫ��,��Ч�ʵ�
	 * ������������䷽ʽĬ��Ϊԭ�����2��
	 */
	public static void vector(){
		List<String> list=new Vector<String>();
		list.add("ff");
		list.add("gg");
		System.out.println(list.size());
	}
	
	public static void copyOnWriteArrayList(){ReentrantLock
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		list.add("ca");
		list.add("cb");
		System.out.println(Arrays.toString(list.toArray()));
	}
}
