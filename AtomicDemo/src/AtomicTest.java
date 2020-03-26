import java.util.concurrent.atomic.AtomicInteger;

/**
 * ���������� Atomic ��ָһ�������ǲ����жϵġ���ʹ���ڶ���߳�һ��ִ�е�ʱ��һ������һ����ʼ���Ͳ��ᱻ�����̸߳���
 * @author Administrator
 *
 */
public class AtomicTest {

	public static void main(String[] args){
		AtomicInteger count = new AtomicInteger(0);
		System.out.println(count);
		
		count.incrementAndGet();
		System.out.println(count);
		
		int temvalue = 0;
		
		temvalue = count.getAndSet(3);
		System.out.println("temvalue:" + temvalue + ";  count:" + count);//temvalue:0;  count:3
		temvalue = count.getAndIncrement();
		System.out.println("temvalue:" + temvalue + ";  count:" + count);//temvalue:3;  count:4
	}
}
