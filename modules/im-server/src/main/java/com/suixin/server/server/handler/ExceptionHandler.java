package com.suixin.server.server.handler;

import com.suixin.server.util.ChannelFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 异常捕捉
 */
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
        System.out.println("Exception");
        cause.printStackTrace();
        Channel channel = ctx.channel();
        ChannelFactory.unbind(channel);
        channel.close();
        ctx.close();
    }

}
