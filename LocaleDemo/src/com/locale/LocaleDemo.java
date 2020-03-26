
package com.locale;

import java.text.MessageFormat;
import java.util.*;


public class LocaleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����������Ի�������
		Locale locale=new Locale("zh","CN");
		Locale locale2=Locale.US;
		Locale locale3=Locale.getDefault();
		//(����.�ļ���������)
		ResourceBundle res=ResourceBundle.getBundle("com.locale.info",locale2);
		Scanner input=new Scanner(System.in);
		
		String userName=res.getString("username");
		System.out.println(userName);
		
		//����̬�ı�
		String msg=res.getString("info.success");
		String str=String.format(msg, "hihi");
		System.out.println(str);
		String str2=MessageFormat.format(msg, "hihi");
		System.out.println(str2);
		
		System.out.println(Math.PI);
	}

}
