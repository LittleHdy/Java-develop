import java.util.Observable;
import java.util.Observer;

public class ObserverDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog=new Dog();
		Person p1=new Person("С��");
		Person p2=new Person("С��");
		
		dog.addObserver(p1);
		dog.addObserver(p2);
		
		System.out.println("С���Żݼ�:"+888);
		dog.setPrice(888);
		
		System.out.println("С���Żݼ�:"+688);
		dog.setPrice(688);
		
		System.out.println("С���Żݼ�:"+588);
		dog.deleteObserver(p2);
		dog.setPrice(588);
	}

}

class Dog extends Observable {
	float price = 1000;

	public float getPricce() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
		this.setChanged();
		this.notifyObservers(price);
	}
}

class Person implements Observer {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(name + " ��ע��С���۸��Ż�Ϊ:" + arg);

	}

}