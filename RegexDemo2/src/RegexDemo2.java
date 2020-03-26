import java.util.regex.*;

public class RegexDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str1 = "s4wte";
		if (str1.matches("[0-9]++")) {
			System.out.println(str1 + " ������");
		} else {
			System.out.println(str1 + " ������");
		}
		
		System.out.println("------------------------------");
		Pattern p=Pattern.compile("\\d+");
		Matcher m=p.matcher(str1);
		if (m.matches()) {
			System.out.println(str1 + " ȫ������.");
		} else {
			System.out.println(str1 + " ��ȫ������.");
		}

		System.out.println("------------------------------");
		String str = "all:person go to;swing.";
		Pattern p2 = Pattern.compile("\\p{Punct}");
		String[] strs = p2.split(str);
		for (String s : strs) {
			System.out.println(s);
		}

		System.out.println("------------------------------");
		String str2 = "010-23454287";
		if(str2.matches("[0-9]{3,4}-\\d{7,8}")){
			System.out.println(str2 + " �绰��ȷ");
		}else{
			System.out.println(str2 + " �绰����ȷ");
		}
		
		System.out.println("------------------------------");
		str2 = "13089876565";
		if(str2.matches("1[3-8][0-9]{9}")){
			System.out.println(str2 + " �ֻ�����ȷ");
		}else{
			System.out.println(str2 + " �ֻ��Ų���ȷ");
		}
		
		System.out.println("------------------------------");
		str2 = "ssu8wa_0";//��ĸ��ͷ,������ĸ�»������
		if(str2.matches("[a-zA-Z]+[\\w|_]*")){
			System.out.println(str2 + " �û�����ȷ");
		}else{
			System.out.println(str2 + " �û�������ȷ");
		}
		
		System.out.println("------------------------------");
		str2 = "192.168.2.122";
		if(str2.matches("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}")){
			System.out.println(str2 + " IP��ȷ");
		}else{
			System.out.println(str2 + " IP����ȷ");
		}
		
		System.out.println("------------------------------");
		str2 = "http://java.lampbrother.net";
		if(str2.matches("http://\\w+.\\w+.\\S*")){
			System.out.println(str2 + " ��ַ��ȷ");
		}else{
			System.out.println(str2 + " ��ַ����ȷ");
		}
		
		System.out.println("------------------------------");
		str2 = "22";//100����
		if(str2.matches("[1-9]{1,2}")){
			System.out.println(str2 + " ������ȷ");
		}else{
			System.out.println(str2 + " ���䲻��ȷ");
		}
		
		System.out.println("------------------------------");
		str2 = "234.324";//С��
		if(str2.matches("[1-9]+.[0-9]+")){
			System.out.println(str2 + " С����ȷ");
		}else{
			System.out.println(str2 + " С������ȷ");
		}
	}

}
