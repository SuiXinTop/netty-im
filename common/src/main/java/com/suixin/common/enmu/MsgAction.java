package com.suixin.common.enmu;

public enum MsgAction {
	
	CONNECT(1, "初始化连接或重连"),
	CHAT(2, "聊天消息"),	
	SIGNED(3, "消息签收"),
	KEEPALIVE(4, "客户端保持心跳"),
	PULL_FRIEND(5, "拉取好友");

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
