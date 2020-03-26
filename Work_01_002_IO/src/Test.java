import java.io.BufferedReader;
import java.io.FileReader;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int c=MyUtil.countWordInFile("D:\\JAVA\\text.txt", "2");
		System.out.println(c);
	}

}

/**
 * дһ������������һ���ļ�����һ���ַ�����ͳ������ַ���������ļ��г��ֵĴ���
 * 
 * @author Administrator
 * 
 */
class MyUtil {

	// �������еķ������Ǿ�̬��ʽ���ʵ���˽�������˽�в�����������(���Ժ�ϰ��)
	private MyUtil() {
		throw new AssertionError();
	}

	/**
	 * ͳ�Ƹ����ļ��и����ַ����ĳ��ִ���
	 * 
	 * @param filename
	 *            �ļ���
	 * @param word
	 *            �ַ���
	 * @return �ַ������ļ��г��ֵĴ���
	 */
	public static int countWordInFile(String filename, String word) {
		int counter = 0;
		try (FileReader fr = new FileReader(filename)) {
			try (BufferedReader br = new BufferedReader(fr)) {
				String line = null;
				while ((line = br.readLine()) != null) {
					int index = -1;
					while (line.length() >= word.length()
							&& (index = line.indexOf(word)) >= 0) {
						counter++;
						line = line.substring(index + word.length());
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return counter;
	}

}
