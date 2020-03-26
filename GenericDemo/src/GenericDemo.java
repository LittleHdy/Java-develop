import java.util.*;
import java.util.Map.Entry;

/**
 * ���� 
 * ����������� 
 * ArrayList<E>:E ��Ϊ���ͱ��������Ͳ��� 
 * ArrayList<Integer>: ��Ϊ������������
 * ArrayList<Integer>: �е�Integer��Ϊ���Ͳ�����ʵ����ʵ�ʲ������� 
 * ArrayList<Integer>: <> ��Ϊtype of 
 * ArrayLIst: ��Ϊԭʼ����
 * 
 * @author Administrator
 * 
 */
public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person<Integer> p1 = new Person<Integer>("С��", 3);
		Person<Float> p2 = new Person<Float>("С��", 2.5f);
		Person<String> p3 = new Person<String>("С��", "����");
		
		int age1 = p1.getAge();
		float age2 = p2.getAge();
		String age3 = p3.getAge();

		// ������������ԭʼ���͵ļ�������
		Collection<String> c = new Vector();
		Collection c2 = new Vector<String>();
		// ���������Ͳ��������ݲ����ļ̳й�ϵ
		// ArrayList<String> c3=new ArrayList<Object>();//����
		// ArrayList<Object> c4=new ArrayList<String>();//����

		// ��ȷ
		ArrayList c5 = new ArrayList<String>();// c5ΪArrayList<Object>
		ArrayList<Object> c6 = c5;

		// �������鲻��ʹ�÷���
		// ArrayList<String>[] c7 = new ArrayList<String>()[10];//����

		// ���Ͳ���
		Person p4 = new Person("С��", 5);
		Object age4 = p4.getAge();
		
		//ʹ��ͨ���[?]
		Person<Float> p5 = new Person<Float>("С��", 2.5f);
		Person<String> p6 = new Person<String>("С��", "����");
		//p5=p6;//����,���������Ͳ�ͬ,�����໥��ֵ		
		print(p5);
		print(p6);
		
		
		//ʹ�÷�������
		Person2<Integer> p7=new Person2<Integer>("С��",5);
		Person2<Double> p8=new Person2<Double>("С��",5.9d);
		//Person2<String> p7=new Person2<String>("С��",5);//����:Tֻ����Number��Number������
		
		//ʹ�÷�������:��ʾֻ��ʹ�þ�����(String)���丸��(Object)
		Person<Integer> p9=new Person<Integer>("С��",5);
		Person<String> p10=new Person<String>("СΪ","����");
		//print2(p9);//����:Integer�಻��String���String��ĸ���
		print2(p10);
		
		
		//ʹ�÷��ͷ���
		String[] name={"С��","С��","С��"};
		name=func(name,0,1);
		for(String s:name){
			System.out.println(s);
		}
		
		//���͵�Ƕ��ʹ��
		//Set<Entry<Integer,String>> entrys=map.entrySet();
		
	}
	
	/**
	 * ʹ��ͨ���[?]�������
	 * @param c
	 */
	private static void print(Person<?> c){
		//c.setAge(10);//����,ʹ��ͨ���ʱֻ�ܻ�ȡ�����޸�
		System.out.println("������: "+c.getAge());
	}
	
	/**
	 * ʹ�÷�������:��ʾֻ��ʹ�þ�����(String)���丸��(Object)
	 * @param c
	 */
	private static void print2(Person<? super String> c){
		//c.setAge(10);//����,ʹ��ͨ���ʱֻ�ܻ�ȡ�����޸�
		System.out.println("������: "+c.getAge());
	}
	
	/**
	 * ʹ�÷��Ͷ��巽��
	 * @param array
	 * @param i
	 * @param j
	 * @return
	 */
	private static <T> T[] func(T[] array,int i,int j){
		T temp=array[i];
		array[i]=array[j];
		array[j]=temp;
		return array;
	}
	
	public static <T> T func3(T[] tt){
		return null;
		
	}
	
	private static <T> int func2(T[] i){
		return 0;
	}
	
	private <T> T func4(T t){
		return t;
		
	}
	
	private <T> String func5(T t){
		return null;
		
	}
}

class Person<T> {
	private String name;
	private T age;

	public Person(String name, T age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getAge() {
		return age;
	}

	public void setAge(T age) {
		this.age = age;
	}
}

/**
 * ����:ʹ�÷�������:��ʾTֻ����Number��Number������
 * @author Administrator
 *
 * @param <T>
 */
class Person2<T extends Number> {
	private String name;
	private T age;

	public Person2(String name, T age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getAge() {
		return age;
	}

	public void setAge(T age) {
		this.age = age;
	}
}

/**
 * ʹ�÷��Ͷ���ӿ�
 * @author Administrator
 *
 * @param <T>
 */
interface IEat<T>{
	void eat(T food);
}
class IEatImpl<T> implements IEat<T>{

	@Override
	public void eat(T food) {
		
	}
	
}







