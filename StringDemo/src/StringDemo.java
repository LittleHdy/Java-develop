
public class StringDemo {

	public static void main(String[] args) {
		test1();
		System.out.println("----------");
		test2();
		
		String s1 = "a";
		String s2 = s1 + "b";
		String s3 = "a" + "b";
		System.out.println(s2 == "ab");
		System.out.println(s3 == "ab");
		
		test3();
	}

	/**
	 * String ��������ִ�����ʽ�� �����ֲ�ͬ�Ĵ����������в��ġ� ��һ�ַ�ʽ���ڳ��������ö���
	 * �ڶ��ַ�ʽ��ֱ���ڶ��ڴ�ռ䴴��һ���µĶ��� ��סһ�㣺ֻҪʹ�� new ����������Ҫ�����µĶ���
	 */
	private static void test1() {
		String str1 = "abcd";// �ȼ���ַ�������������û��"abcd"������ַ�����������û�У��򴴽�һ����Ȼ�� str1
								// ָ���ַ����������еĶ�������У���ֱ�ӽ� str1 ָ��"abcd""��
		String str2 = new String("abcd");// ���д���һ���µĶ���
		String str3 = new String("abcd");// ���д���һ���µĶ���
		System.out.println(str1 == str2);// false
		System.out.println(str2 == str3);// false
	}

	/**
	 * String ���͵ĳ����رȽ����⡣������Ҫʹ�÷��������֣�
	 * 
	 * ֱ��ʹ��˫�������������� String �����ֱ�Ӵ洢�ڳ������С� ���������˫���������� String ���󣬿���ʹ�� String �ṩ��
	 * intern ������String.intern() ��һ�� Native ���������������ǣ��������ʱ���������Ѿ�����һ�����ڴ� String
	 * �������ݵ��ַ������򷵻س������и��ַ��������ã����û�У����ڳ������д������ String ������ͬ���ַ����������س������д������ַ��������á�
	 */
	private static void test2() {
		String s1 = new String("�����");
		String s2 = s1.intern();
		String s3 = "�����";
		System.out.println(s2);// �����
		System.out.println(s1 == s2);// false����Ϊһ���Ƕ��ڴ��е� String ����һ���ǳ������е�
										// String ����
		System.out.println(s3 == s2);// true����Ϊ�������ǳ������е� String ����
	}

	private static void test3() {
		String str1 = "str";
		String str2 = "ing";

		String str3 = "str" + "ing";// �������еĶ���
		String str4 = str1 + str2; // �ڶ��ϴ������µĶ���
		String str5 = "string";// �������еĶ���
		System.out.println(str3 == str4);// false
		System.out.println(str3 == str5);// true
		System.out.println(str4 == str5);// false
	}

	/**
	 * String s1 = new String("abc");��仰�����˼����ַ������� ������ 1 �� 2
	 * ���ַ�������������Ѵ����ַ������֡�abc���������ֻ�ᴴ��һ���ַ�����s1�����������û���ַ������֡�abc������ô���������ڳ��д�����
	 * Ȼ���ڶѿռ��д�������˽������ܹ� 2 ���ַ�������
	 */
	private static void test4() {
		String s1 = new String("abc");// ���ڴ�ĵ�ֵַ
		String s2 = "abc";
		System.out.println(s1 == s2);// ��� false,��Ϊһ���Ƕ��ڴ棬һ���ǳ����ص��ڴ棬�������ǲ�ͬ�ġ�
		System.out.println(s1.equals(s2));// ��� true
	}
}
