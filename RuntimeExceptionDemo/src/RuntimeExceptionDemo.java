
public class RuntimeExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	public static void test(){
		//...
		throw new MyRuntimeException();
	}
}
//���ܼ��쳣
class MyRuntimeException extends RuntimeException{
	public MyRuntimeException(){
		super();
	}
}
