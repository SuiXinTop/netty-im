package com.suixin.server.server.handler;

import com.suixin.common.entity.dto.BindMsg;
import com.suixin.server.util.ChannelFactory;
import com.suixin.server.util.WebSocketResult;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

@ChannelHandler.Sharable
public class BindMsgHandler extends SimpleChannelInboundHandler<BindMsg> {

    private static final BindMsgHandler INSTANCE = new BindMsgHandler();

    public static BindMsgHandler getInstance() {
        return INSTANCE;
    }

    //服务器读取消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BindMsg msg) {
        System.out.println("BindMsgHandler");
        ChannelFactory.bind(msg.getUserId(), ctx.channel());
        ctx.writeAndFlush(WebSocketResult.trans(msg));
    }
}
