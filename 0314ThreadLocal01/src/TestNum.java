
public class TestNum {
	//ͨ�������ڲ��า��ThreadLocal��initialValue()������ָ����ʼֵ
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		@Override
		public Integer initialValue(){
			return 0;
		}
	};
	
	public static int getNextNum(){
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
}
