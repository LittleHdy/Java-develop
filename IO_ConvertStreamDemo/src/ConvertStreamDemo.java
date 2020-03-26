import java.io.*;

public class ConvertStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		writer();
		reader();
	}

	//�ַ������ת�����ֽ������:�ַ�->ת���ֽ���->�ļ�
	private static void writer() {
		try {
			OutputStream out = new FileOutputStream("D:\\JAVA\\text.txt");
			String info = "��Ԫ 2014-06-11 ";
			//ͨ���ֽ�����������ַ������
			Writer writer = new OutputStreamWriter(out);
			writer.write(info);

			writer.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//�ֽ�������ת�����ַ�������:�ļ�->ת���ַ���->����
	private static void reader() {
		try {
			InputStream in = new FileInputStream("D:\\JAVA\\text.txt");
			//ͨ���ֽ������������ַ�������
			Reader reader = new InputStreamReader(in);
			
			char[] chars = new char[7];
			int len = -1;
			StringBuilder sb = new StringBuilder();
			while ((len = reader.read(chars)) != -1) {
				sb.append(new String(chars, 0, len));
			}

			in.close();
			reader.close();

			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
