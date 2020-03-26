import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DynamicProxyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p=new Person("С��");
		DynamicProxy dp=new DynamicProxy(p);
		
		Subject s=(Subject)Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), dp);
		s.miai();
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

class DynamicProxy implements InvocationHandler{

	Subject target;
	public DynamicProxy(Subject target){
		this.target=target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object obj=null;
		obj=method.invoke(target, args);
		after();
		return obj;
	}
	
	private void before(){
		System.out.println("����֮ǰ���д���...");
	}
	private void after(){
		System.out.println("����֮����д���...");
	}
}