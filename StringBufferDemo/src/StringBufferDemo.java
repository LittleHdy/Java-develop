
public class StringBufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="123";
		//Ĭ���ַ�����Ĵ�СΪ16
		//ͬ����,���̷߳���ʱ��ȫ
		StringBuffer sb=new StringBuffer();
		sb.append("456789");
		System.out.println(sb.toString());
		
		//StringBilder�� StringBuffer����,����StringBuffer��,���Ȳ���StringBuilder
		//��ͬ����,���̷߳���ʱ����ȫ,���߳�ʱʹ��Ч�ʸ���
		StringBuilder sbl=new StringBuilder();
		sbl.append("abc").append("def");
		System.out.println(sbl.toString());
		
		String sb2 = new String(new byte[]{'2','3'});
		System.out.println(sb2);
		
		long l1 = Long.parseLong(sb2);
		System.out.println(l1);
		
		byte b1 = (byte)333;
		System.out.println(b1);
	}

}
