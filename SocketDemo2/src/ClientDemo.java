import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * echo �ͻ���
 * @author Administrator
 *
 */
public class ClientDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket s=new Socket("127.0.0.1",8000);
			System.out.println("���ӷ������ɹ�...");
			boolean flag=true;
			Scanner input=new Scanner(System.in);
			//��ȡ���������
			PrintStream ps=new PrintStream(
					new BufferedOutputStream(s.getOutputStream()));
			BufferedReader br=new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			while(flag){
				System.out.println("������:");
				String info=input.next();
				if(info.equals("bye")){
					flag=false;
				}
				ps.println(info);
				ps.flush();
				String re = br.readLine();
				System.out.println(re);
			}
			br.close();
			ps.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
