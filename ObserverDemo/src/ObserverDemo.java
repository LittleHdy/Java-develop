import java.util.ArrayList;

/**
 * �۲���ģʽ 
 * Subject (���۲�Ķ���ӿ�) 
 * 		�涨ConcreteSubject��ͳһ�ӿ� 
 * 		ÿ��Subject�����ж��Observer
 * ConcreteSubject(���屻�۲����) 
 * 		ά�������о���۲��ߵ������б� 
 * 		״̬�����仯ʱ����֪ͨ������ע��Ĺ۲��� 
 * Observer(�۲��߽ӿ�)
 * 		�涨ConcreteObserver��ͳһ�ӿ� 
 * 		������һ��update()���� 
 * ConcreteObserver(����۲��߶���)
 * 		ά��һ����ConcreteSubject������ 
 * 		�ض�״̬��ConcreteSubjectͬ��
 * 		ʵ��Observer�ӿ�,ͨ��update()��������ConcreteSubject��֪ͨ
 * 
 * @author Administrator
 * 
 */
public class ObserverDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog=new Dog();
		Person p1=new Person("С��");
		Person p2=new Person("С��");
		
		dog.registerObserver(p1);
		dog.registerObserver(p2);
		
		System.out.println("С���Żݼ�:"+888);
		dog.setPrice(888);
		
		System.out.println("С���Żݼ�:"+688);
		dog.setPrice(688);
		
		System.out.println("С���Żݼ�:"+588);
		dog.removeObserver(p2);
		dog.setPrice(588);
	}

}

/**
 * ���۲�Ķ���ӿ�
 * 
 * @author Administrator
 * 
 */
interface Subject {
	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObserver();
}

/**
 * ���۲����:С��
 * 
 * @author Administrator
 * 
 */
class Dog implements Subject {
	ArrayList<Observer> list = new ArrayList<Observer>();
	private float price=1000;

	public void setPrice(float price) {
		this.price = price;
		notifyObserver();
	}

	@Override
	public void registerObserver(Observer o) {
		list.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		list.remove(o);
	}

	@Override
	public void notifyObserver() {
		for (Observer o : list) {
			o.update(this.price);
		}
	}
}

/**
 * �۲��߶���ӿ�
 * 
 * @author Administrator
 * 
 */
interface Observer {
	void update(float price);
}

class Person implements Observer {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public void update(float price) {
		System.out.println(name + " ��ע��С���۸�䶯Ϊ:" + price);
	}

}
