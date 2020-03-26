
import java.io.*;

public class BufferedStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		write();
		read();
	}
	
	private static void write(){
		try {
			OutputStream out=new FileOutputStream("D:\\JAVA\\text.txt");
			BufferedOutputStream bos=new BufferedOutputStream(out);
			
			String info="good good study,day day up! ��������";
			byte[] bytes=info.getBytes();
			bos.write(bytes);
			bos.flush();//flushд��
			
			bos.close();//closeҲ��д��
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	///ʹ���ֽڻ��������ж�ȡ����
	private static void read(){
		try {
			InputStream in=new FileInputStream("D:\\JAVA\\text.txt");
			char[] chars=new char[512];
			int len=-1;
			BufferedInputStream bis=new BufferedInputStream(in);
			Reader reader=new InputStreamReader(bis);
			StringBuilder sb=new StringBuilder();
			while((len=reader.read(chars))!=-1){
				sb.append(new String(chars,0,len));
			}
			
			bis.close();
			in.close();
			
			System.out.println(sb.toString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
