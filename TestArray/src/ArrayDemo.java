
public class ArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names={"11","cc","ww","22"};
		method(names);
		
		System.out.println("");
		method2("22","44");
		System.out.println("");
		method2("22","44","cc","kk");
	}
	private static void method(String[] names){
		//��һ���forѭ���ķѸ����ڴ�
		for(String name:names){
			System.out.print(name+" ");
		}
	}
	//�ɱ����
	private static void method2(String...names){
		//��һ���forѭ���ķѸ����ڴ�
		for(String name:names){
			System.out.print(name+" ");
		}
	}
}
