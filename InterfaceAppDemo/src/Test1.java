
/**
 * �ӿ�:interface
 * 1.�ӿ�����ȫ�����,������ǹ���,����
 * 2.�ӿڲ��ܱ�ʵ����
 * 3.�ӿ���ֻ�����������ͳ��󷽷�
 * 4.����ʵ�ֽӿ�,����ʵ�ֽӿ������еķ���
 * 5.�ӿڿ��Լ̳�һ�������ӿ�,ʹ��extends�ؼ���
 * 6.�ӿڿ��԰������ӿ�
 * @author Administrator
 *
 */

interface MyInterface{
	public static final int NUM=1;
	public static int num=10;
	public int num2=1;
	int num3=21;
	
	public abstract void method1();
	public void method2();
	void method3();
	
	class A{
		
	}
	
	abstract class AbstractClass{
		
	}
	
	interface InterfaceXX{
		
	}
}

interface MyInterface2 extends MyInterface{
	void fun();
}

interface MyInterface3 extends MyInterface,MyInterface2{
	void fun();
}

class MyInterfaceImpl implements MyInterface{

	@Override
	public void method1() {
		System.out.println("method1");
	}

	@Override
	public void method2() {
		System.out.println("method2");
	}

	@Override
	public void method3() {
		System.out.println("method3");		
	}
	
}

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyInterfaceImpl impl=new MyInterfaceImpl();
		impl.method1();
		impl.method2();
		impl.method3();
	}

}
