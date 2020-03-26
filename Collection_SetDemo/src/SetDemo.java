import java.util.*;


public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		hashSet();
		treeSet();
		linkedHashSet();
	}
	
	/**
	 * LinkedHashSet
	 * ʹ�ù�ϣ��+˫������
	 * ���Բ���˳�����
	 * �ײ�ʹ��LinkHashMapʵ��
	 */
	public static void linkedHashSet(){
		System.out.println("---------------------------------------");
		Emp p1=new Emp("aa",23);
		Emp p2=new Emp("bb",24);
		Emp p3=new Emp("cc",17);
		Emp p4=new Emp("ddb",16);
		Set<Emp> persons=new LinkedHashSet<Emp>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		System.out.println(persons);
	}
	
	/**
	 * TreeSet
	 * �����
	 * �ײ�ʹ��TreeMapʵ��
	 * ����TreeSet�д洢�Զ������ʱ����ʵ��Comparable�ӿ�
	 */
	public static void treeSet(){
		System.out.println("---------------------------------------");
		Emp p1=new Emp("aa",23);
		Emp p2=new Emp("bb",24);
		Emp p3=new Emp("cc",17);
		Emp p4=new Emp("ddb",16);
		Set<Emp> persons=new TreeSet<Emp>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(new Emp("tt",23));//23�ظ�
		System.out.println(persons.size());
		
		Emp[] emps=persons.toArray(new Emp[]{});
		for(Emp e : emps){
			System.out.println(e.getAge());
		}
	}
	
	/**
	 * HashSet 
	 * ����֤����˳��
	 * �ײ�ʹ��HashMapʵ��
	 * �Ѵ���Ķ�����ΪHashMap��Keyֵ����HashMap��Valueֵʹ��ͬһ��Object����
	 * ������ʽ��
	 * 		1)ʹ�õ�����Iterator�������Ƽ���
	 * 		2)foreach���� 
	 * 		3)��set����ת����������б���
	 * �������ظ�Ԫ�ص� collection����ȷ�еؽ���set ���������� e1.equals(e2) ��Ԫ�ض� e1 �� e2
	 */
	public static void hashSet(){
		Set<String> set=new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("b");
		System.out.println(set.size());
		
		String[] arr= set.toArray(new String[]{});
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		System.out.println("---------------------------------------");
		Person p1=new Person("aa",23);
		Person p2=new Person("bb",23);
		Person p3=new Person("cc",23);
		Person p4=new Person("ddb",23);
		Set<Person> persons=new HashSet<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(new Person("cc",23));//�ظ���
		System.out.println(persons.size());
		
	}
}
/**
 * �ж϶����Ƿ���ȣ����ж�hashcode,���ж�equals
 * @author Administrator
 *
 */
class Person{
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

class Emp implements Comparable<Emp>{
	public Emp(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	@Override
	public int compareTo(Emp o) {
		if(null==o)
			throw new NullPointerException("");
		if(this.age>o.age)
			return -1;
		if(this.age<o.age)
			return 1;
		return 0;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", age=" + age + "]";
	}
	
	
}
