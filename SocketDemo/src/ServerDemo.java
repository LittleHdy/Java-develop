import java.io.*;
import java.io.IOException;
import java.net.*;

/**
 * TCP�������˳���
 * 
 * @author Administrator
 * 
 */
public class ServerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����һ����������Socket
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("������������,���ڵȴ�����...");
			Socket socket = server.accept();// �ȴ��ͻ�������,������
			String info="�ż��ѷ���,��ע�����...";
			//����һ���ַ������
			BufferedWriter  bw= new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			bw.write(info);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
