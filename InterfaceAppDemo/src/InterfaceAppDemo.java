

//OO���ԭ��
//����ӿڱ��(���������)
//��װ�仯
//�������,���ü̳�

//����ģʽ
public class InterfaceAppDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p=new Person("me");
		Isay isay=new Say1();
		p.setIsay(isay);
		p.say();
		
		isay=new Say2();
		p.setIsay(isay);
		p.say();
	}

}
interface Isay{
	void say();
}

class Person{
	private String name;
	//�ѿɱ� ��Ϊ�������,����ɽӿ�,���ṩ��ͬʵ��
	private Isay isay;
	public void setIsay(Isay isay){
		this.isay=isay;
	}
	
	public Person(String name){
		this.name=name;
	}
	
	void say(){
		isay.say();
	}
}

class Say1 implements Isay{
	public void say(){
		System.out.println("say 1.");
	}
}
class Say2 implements Isay{
	public void say(){
		System.out.println("say 2.");
	}
}
