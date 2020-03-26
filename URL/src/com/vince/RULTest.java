package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class RULTest {

	public static void main(String[] args){
		String urlPath="http://pic.baidu.com/static/widget/channel/loading/loadingPD_9352a443db.gif";
		try {
			URL url=new URL(urlPath);
			System.out.println("Э��:"+url.getProtocol());
			System.out.println("����:"+url.getHost());
			System.out.println("�˿�:"+url.getPort());
			System.out.println("�ļ�:"+url.getFile());
			
			BufferedInputStream bis=new BufferedInputStream(url.openStream());
			
			String newFilePath="c:/loadingPD_9352a443db.gif";
			File file=new File(newFilePath);
			FileOutputStream fos=new FileOutputStream(file);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			
			int len=0;
			byte[] bytes=new byte[1024];
			while((len=bis.read(bytes))!=-1){
				bos.write(bytes, 0, len);
			}
			
			bos.close();
			bis.close();
			
			System.out.println("success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
