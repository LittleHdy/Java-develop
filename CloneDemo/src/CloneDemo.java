public class CloneDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cat c = new Cat("haha", 3);
		try {
			Cat c1 = (Cat) c.clone();
			System.out.println(c1);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

/*
 * һ����Ҫ��ʵ�ֿ�¡,���� 
 * 1.ʵ��Cloneable�ӿ�,�ýӿ���һ����ǽӿ�,û���κη��� 
 * 2.��дObject���е�clone����
 * ��Ҫ����һ�����ʱ,ʹ�ÿ�¡��ʹ��new��������ЧӦҪ��
 */
class Cat implements Cloneable {
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;

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

	@Override
	public String toString() {
		return name + ":" + age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}