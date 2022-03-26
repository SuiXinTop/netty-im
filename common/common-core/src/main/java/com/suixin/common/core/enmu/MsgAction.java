package com.suixin.common.core.enmu;

public enum MsgAction {
	
	CONNECT(1, "初始化连接或重连"),
	CHAT(2, "聊天消息"),	
	KEEPALIVE(3, "客户端保持心跳");

	public final int type;
	public final String content;
	
	MsgAction(int type, String content){
		this.type = type;
		this.content = content;
	}
	
	public int getType() {
		return type;
	}  
}
