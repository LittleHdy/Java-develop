import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class OutPutStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testFileOutputStream();
	}

	private static void testFileOutputStream(){
		try {
			OutputStream stream=new FileOutputStream("D:\\JAVA\\text.txt");
			String str="Hellow FileOutputStream!�ļ�����������ڽ�����д��";
			byte[] b=str.getBytes();
			
			stream.write(b);
			//for (int i = 0; i < b.length; i++) {
			//	stream.write(b[i]);
			//}
			
			stream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
