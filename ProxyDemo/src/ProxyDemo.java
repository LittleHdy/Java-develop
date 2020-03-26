
//��̬����ģʽ
public class ProxyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p=new Person("ll");
		MatchMaker m=new MatchMaker(p);
		m.miai();
	}

}
//����
interface Subject{
	void miai();
}
//���������
class Person implements Subject{
	private String name;
	public Person(String name){
		this.name=name;
	}
	public void miai(){
		System.out.println(name+" ������...");
	}
}
//�������
class MatchMaker implements Subject{
	private Subject target;
	public MatchMaker(Subject p){
		target=p;
	}
	private void before(){
		System.out.println("����֮ǰ���д���...");
	}
	private void after(){
		System.out.println("����֮����д���...");
	}
	
	public void miai(){
		before();
		target.miai();
		after();
	}
}

