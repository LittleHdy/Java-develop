import java.util.*;

/**
 * �Ƚ����������Ƿ����,ͨ���Ƚ�hashCode()��equals(),hashCode��ȵĶ���һ�����
 * HashSetͨ����������hashCode()��ֵ���洢����������,�������hashCode()�ı��,��HashSet�о��Ҳ����ö���,
 * ��������޸��������ɾ���ö���,����ɾ���ɹ�
 * @author Administrator
 *
 */
public class HashCodeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Person> set=new HashSet<Person>();
		Person p1=new Person(12,"ad");
		//System.out.println(p1.hashCode());
		Person p2=new Person(12,"AD");
		//System.out.println(p2.hashCode());

		System.out.println("ad".hashCode());
		System.out.println("AD".hashCode());
		
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());
		
		System.out.println("--------------------");
		
		p1.setAge(14);
		set.remove(p1);
		System.out.println(set.size());
	}

}

class Person{
	private int age;
	private String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
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
	public int hashCode() {
		System.out.println("�ж�hashcode");
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("�ж�equals");
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
