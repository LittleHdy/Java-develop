import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


public class MapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		hashMap();
		treeMap();
		System.out.println("-------------------------------");
		linkedHashMap();

		System.out.println("-------------------------------");
		concurrentHashMap();
	}

	/**
	 *HashMap:
	 * 1�����ڹ�ϣ��� Map �ӿڵ�ʵ��:��������+����
	 * 2������ʹ�� null ֵ�� null ��
	 * 3����ȷ��˳��
	 * 4����ͬ�ļ�ֵ����󸲸ǵķ�ʽ���д洢
	 * 5��Ĭ�ϵ�����������С��16������������0.75
	 * 6������Ĵ洢�㷨���Ȼ�ȡ�ö����hashCodeֵ����HashMap������ȡ���ֵΪ�ö���
	 * 	�������е�λ�á�
	 * 7�����Ҷ��󣬻�ȡ�ö����hashCodeֵ�Ե�ǰ����ȡ���ֵΪ�±꣬����ָ������λ��
	 * �Ķ�����������ڶ༶�����У��������
	 * 8����ϣ�������ɢ�У������������䣩�������ĺܴ�����ܣ�����Ҫ��������
	 * 9������洢�Ķ���������Ԥ֪����ô����ʹ���Զ����ʼ�����ͼ������ӣ����ι�������
	 * 10���̲߳���ȫ
	 */
	public static void hashMap(){
		Map<Integer,String> m=new HashMap<Integer,String>();
		m.put(1, "a");
		m.put(2, "cc");
		Set<Integer> keys=m.keySet();
		Iterator<Integer> ite=keys.iterator();
		while(ite.hasNext()){
			System.out.println(m.get(ite.next()));
		}
	}
	
	/**
	 * Hashtable
	 * ��HashMap����
	 * �������ֵΪnull
	 * ��Ĭ�ϳ�ʼ��ʼ����11�ͼ�������0.75����һ���µĿչ�ϣ��
	 * �̰߳�ȫ��,ͬ��
	 */
	public static void hashtable(){
		Hashtable<Integer,String> t=new Hashtable<Integer,String>();
		t.put(1, "sew");
	}
	
	/**
	 * TreeMap
	 * ���ڶ������еĺ����ʵ��,�������һ����ƽ������������
	 * ʹ�ü�����Ȼ˳����һ���µġ��յ���ӳ��
	 * ʹ���Զ��������ΪKEYֵʱ,�ö���Ӧʵ�� Comparable�ӿ�
	 */
	public static void treeMap(){
		Map<Person,String> m=new TreeMap<Person,String>();
		m.put( new Person(12,"aaa"),"e");
		m.put( new Person(34,"bbc"),"oos");
		m.put( new Person(23,"yu"),"fw");
		System.out.println(m.size());
		Set<Entry<Person,String>> ps=m.entrySet();
		Iterator<Entry<Person,String>> it=ps.iterator();
		while(it.hasNext()){
			Entry<Person,String> en=it.next();
			System.out.println(en.getValue()+":"+en);
		}
	}
	
	/**
	 *  LinkedHashMap:
	 * ��HashMap������
	 * ���п�Ԥ֪�ĵ���˳��
	 * ��ʵ���� HashMap �Ĳ�֮ͬ�����ڣ�����ά����һ��������������Ŀ��˫�������б�
	 * �������б����˵���˳�򣬸õ���˳��ͨ�����ǽ������뵽ӳ���е�˳�򣨲���˳�򣩡�
	 */
	public static void linkedHashMap(){
		Map<Person,String> m=new LinkedHashMap<Person,String>();
		m.put( new Person(12,"aaa"),"e");
		m.put( new Person(23,"bbc"),"oos");
		m.put( new Person(34,"yu"),"fw");
		System.out.println(m.size());
		Collection<String> ss=m.values();
		for(String s:ss){
			System.out.println(s);
		}
	}
	
	public static void concurrentHashMap(){
		ConcurrentHashMap<Person, String> map = new ConcurrentHashMap<>();
		map.put( new Person(12,"aaa"),"ca");
		map.put( new Person(23,"bbc"),"cb");
		map.put( new Person(34,"yu"),"cc");
		
		Set<Entry<Person, String>> set = map.entrySet();
		Iterator<Entry<Person, String>> it = set.iterator();
		while(it.hasNext()){
			Entry<Person, String> en = it.next();
			System.out.println(en.getValue() + ":" + en);
		}
	}
}

class Person implements Comparable<Person> {
	private int age;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Person o) {
		if(null==o)
			throw new NullPointerException("");
		if(o.age>this.age)
			return 1;
		else if(o.age<=this.age)
			return -1;
		return 0;
	}
}