package com.vince;

import java.io.Serializable;

public class Info implements Serializable  {

	private String srcName;//������
	private String destName;//������
	private String msg;
	private int msgType;//��Ϣ����:1��ʾ��¼,2��ʾ������Ϣ
	
	public Info(String srcName, String destName, String msg, int msgType) {
		super();
		this.srcName = srcName;
		this.destName = destName;
		this.msg = msg;
		this.msgType = msgType;
	}
	public String getSrcName() {
		return srcName;
	}
	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}
	public String getDestName() {
		return destName;
	}
	public void setDestName(String destName) {
		this.destName = destName;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	
}
