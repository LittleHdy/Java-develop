

//�����ڲ���
public class InnerClassDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�̳�ʽ�����ڲ���
		Dog dog=new Dog("aa"){
			public void say(){
				System.out.println("���� inner class "+name);
			}
		};
		dog.say();
	}

}
class Dog{
	protected String name;
	public Dog(String name){
		this.name=name;
	}
	
	public void say(){
		System.out.println("Outer class "+name);
	}
}
