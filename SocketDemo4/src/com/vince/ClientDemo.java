package com.vince;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo {

	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		try {
			Socket socket=new Socket("127.0.0.1",9999);
			System.out.println("���ӷ������ɹ�");
			
			System.out.println("�������¼��:");
			String srcName=in.next();
			Info info=new Info(srcName, "", "", 1);
			
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(info);
			
			//����������Ϣ���߳�
			new Thread(new ReceiverThread(socket)).start();
			
			while(true){
				System.out.println("������Ҫ������Ϣ���û���:");
				String destName=in.next();
				System.out.println("�����뷢����Ϣ:");
				String msg=in.next();
				info=new Info(srcName, destName, msg, 2);
				oos.writeObject(info);
				oos.flush();
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ReceiverThread implements Runnable{
	private Socket socket;
	private boolean flag;	

	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public ReceiverThread(Socket socket)
	{
		this.socket=socket;
		flag=true;
	}
	
	@Override
	public void run() {
		try {			
			while(flag){		
				ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
				Info info=(Info)ois.readObject();
				System.out.println(info.getSrcName()+" �� "+info.getDestName()+" ˵:"+info.getMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
