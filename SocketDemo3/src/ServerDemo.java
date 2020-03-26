import java.io.*;
import java.net.*;

/**
 * echo ��������
 * 
 * @author Administrator
 * 
 */
public class ServerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ������������ socket
		try {
			ServerSocket ss = new ServerSocket(8000);
			System.out.println("������������");
			boolean flag = true;
			while (flag) {
				System.out.println("���ڵȴ�����...");
				Socket s = ss.accept();
				//
				new Thread(new MultipleSocketThread(s)).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MultipleSocketThread implements Runnable {

	private Socket s;

	public MultipleSocketThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			System.out.println(s.getInetAddress().getHostAddress() + " ������...");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			PrintStream ps = new PrintStream(new BufferedOutputStream(
					s.getOutputStream()));
			boolean bool = true;
			while (bool) {// ѭ����������
				String info = br.readLine();
				if (info.equals("bye")) {
					bool = false;
				}
				System.out.println(info);
				ps.println("echo:" + info);
				ps.flush();
			}
			ps.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
