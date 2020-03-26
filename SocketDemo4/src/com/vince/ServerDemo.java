package com.vince;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

/**
 * �������֮�����
 * @author Administrator
 *
 */
public class ServerDemo {

	public static void main(String[] args){
		List<UserThread> list=new Vector<UserThread>();
		try {
			ServerSocket server=new ServerSocket(9999);
			System.out.println("����������,�ȴ�����...");
			while(true){
				Socket socket=server.accept();
				System.out.println(socket.getInetAddress().getHostAddress()+" ������");
				UserThread ut=new UserThread(socket, list);
				list.add(ut);
				new Thread(ut).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class UserThread implements Runnable{
	private String userName;
	private Socket socket;
	private List<UserThread> userThreads;
	public UserThread(Socket socket,List<UserThread> userThreads){
		this.socket=socket;
		this.userThreads=userThreads;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
		
			while(true){
				Info info=(Info)ois.readObject();
				if(info.getMsgType()==1){
					userName=info.getSrcName();
					System.out.println(info.getSrcName()+" �ѵ�¼");
				}else if(info.getMsgType()==2){
					for(UserThread ut : userThreads){
						if(info.getDestName().equals(ut.userName)){//�ҵ�Ҫ������Ϣ�Ŀͻ���
							ObjectOutputStream oos =new ObjectOutputStream(ut.socket.getOutputStream());
							oos.writeObject(info);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
