
import java.io.*;

public class PrintWriterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print();
	}
	
	private static void print(){
		try {
			Writer w = new FileWriter("D:\\JAVA\\text.txt");
			BufferedWriter bos = new BufferedWriter(w);
			PrintWriter pw=new PrintWriter(bos);
			
			pw.println("\r");//����
			pw.println("�ַ���");
			pw.println("\r");//����
			pw.println(2322);
			pw.print(true);
			pw.flush();
			
			pw.close();
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
