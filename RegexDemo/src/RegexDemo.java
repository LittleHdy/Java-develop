
/**
 * ������ʽ
 * @author Administrator
 *
 */
public class RegexDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "1232821";
		fun1(str);
		//ʹ��������ʽ
		fun2(str);
	}

	private static void fun1(String str) {
		boolean flag = true;
		char[] chars = str.toCharArray();
		for (char c : chars) {
			if (c < '0' || c > '9') {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println(str + " ȫ������.");
		} else {
			System.out.println(str + " ��ȫ������.");
		}
	}
	
	private static void fun2(String str){
		if (str.matches("\\d+")) {
			System.out.println(str + " ȫ������.");
		} else {
			System.out.println(str + " ��ȫ������.");
		}
	}
}
