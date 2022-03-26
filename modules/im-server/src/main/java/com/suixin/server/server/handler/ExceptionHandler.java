package com.suixin.server.server.handler;

import com.suixin.common.entity.dto.TransMsg;
import com.suixin.server.util.WebSocketResult;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 异常捕捉
 */
@ChannelHandler.Sharable
public class ExceptionHandler extends ChannelInboundHandlerAdapter {

    private static final ExceptionHandler INSTANCE = new ExceptionHandler();

    public static ExceptionHandler getInstance() {
        return INSTANCE;
    }

    /**
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.channel().writeAndFlush(WebSocketResult.trans(new TransMsg(9, 9, "出现未知错误")));
//        Channel channel = ctx.channel();
//        ChannelFactory.unbind(channel);
//        channel.close();
//        ctx.close();
    }

}
