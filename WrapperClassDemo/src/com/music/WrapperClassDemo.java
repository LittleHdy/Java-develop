package com.music;

public class WrapperClassDemo {

	/**
	 * Java �������͵İ�װ��Ĵ󲿷ֶ�ʵ���˳����ؼ������� Byte,Short,Integer,Long,Character,Boolean����
	 * 5 �ְ�װ��Ĭ�ϴ�������ֵ[-128��127] ����Ӧ���͵Ļ������ݣ����ǳ����˷�Χ��Ȼ��ȥ�����µĶ��� ���ָ��������͵İ�װ��
	 * Float,Double ��û��ʵ�ֳ����ؼ�����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Integerֱ�Ӹ�ֵʱ,��ֵΪ1���ֽ�(-128-127)����ʱ,��ʹ��ͬһ������
		// Byte,Short,Integer,Long �õ�����Ԫ���ģʽ
		Integer x1 = 1000;
		Integer x2 = 1000;
		System.out.println(x1 == x2);

		System.out.println("----------");
		test1();
		System.out.println("----------");
		test2();

	}

	private static void test1() {
		Integer i1 = 33;
		Integer i2 = 33;
		System.out.println(i1 == i2);// ��� true
		Integer i11 = 333;
		Integer i22 = 333;
		System.out.println(i11 == i22);// ��� false
		Double i3 = 1.2;
		Double i4 = 1.2;
		System.out.println(i3 == i4);// ��� false

		Integer i5 = 40;
		Integer i6 = new Integer(40);
		System.out.println(i5 == i6);// ��� false
	}

	private static void test2() {
		Integer i1 = 40;
		Integer i2 = 40;
		Integer i3 = 0;
		Integer i4 = new Integer(40);
		Integer i5 = new Integer(40);
		Integer i6 = new Integer(0);

		System.out.println("i1=i2   " + (i1 == i2));// true
		System.out.println("i1=i2+i3   " + (i1 == i2 + i3));// true
		System.out.println("i1=i4   " + (i1 == i4));// false
		System.out.println("i4=i5   " + (i4 == i5));// false
		// ��� i4 == i5 + i6����Ϊ+����������������� Integer �������� i5 �� i6 �����Զ����������������ֵ��ӣ���
		// i4 == 40��Ȼ�� Integer �����޷�����ֵ����ֱ�ӱȽϣ����� i4 �Զ�����תΪ int ֵ 40�������������תΪ 40
		// == 40 ������ֵ�Ƚϡ�
		System.out.println("i4=i5+i6   " + (i4 == i5 + i6)); // true
		System.out.println("40=i5+i6   " + (40 == i5 + i6));// true
		System.out.println("40=i5+i6   " + (i4 == i5 + 0));//true
		System.out.println("40=i5+i6   " + (40 == i5 + 0));//true
	}

}
