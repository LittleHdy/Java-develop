
//��̬�ڲ���:�൱���ⲿ��
public class InnerClassDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog("hh");
		dog.say();				
		dog.childTalk();
		
		Dog.ChildDog child=new Dog.ChildDog();
		child.talk();
	}

}
class Dog{
	private String name;
	private static String Addr="gz";
	public Dog(String name){
		this.name=name;
	}
	
	public void say(){
		System.out.println("Outer class "+name);
	}
	//�ڲ���(��Ա�ڲ���)
	static class ChildDog{//staticҪ����class�Ļ�,ֻ�������ڲ���
		public void talk(){
			System.out.println("Inner class "+Addr);
		}
	}
	
	public void childTalk(){
		ChildDog dog=new ChildDog();
		dog.talk();
	}
}
