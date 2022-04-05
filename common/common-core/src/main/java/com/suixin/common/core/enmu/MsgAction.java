package com.suixin.common.core.enmu;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;


@Getter
public enum MsgAction {
	
	CONNECT(1, "初始化连接或重连"),
	CHAT(2, "聊天消息"),	
	KEEPALIVE(3, "客户端保持心跳"),
	ERROR(9,"出现未知错误");

	@EnumValue
	private final int type;
	private final String content;
	
	MsgAction(int type, String content){
		this.type = type;
		this.content = content;
	}

}
