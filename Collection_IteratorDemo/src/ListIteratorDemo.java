import java.util.*;


public class ListIteratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> l=new ArrayList<String>();
		l.add("a");
		l.add("cc");
		l.add("bb");
		listIterator(l);
	}

	public static void listIterator(List<String> l){
		ListIterator<String> li=l.listIterator();
		//��ǰ�� ��
		while(li.hasNext()){
			System.out.println(li.next());
		}
		System.out.println("-----------------------");
		//�Ӻ���ǰ
		while(li.hasPrevious()){
			System.out.println(li.previous());
		}
	}
}
