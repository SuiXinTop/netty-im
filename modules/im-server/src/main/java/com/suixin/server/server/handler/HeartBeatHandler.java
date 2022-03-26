package com.suixin.server.server.handler;

import com.suixin.server.util.ChannelFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 心跳包用户触发
 */
@ChannelHandler.Sharable
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    private static final HeartBeatHandler INSTANCE = new HeartBeatHandler();

    public static HeartBeatHandler getInstance() {
        return INSTANCE;
    }

    /**
     * @param ctx
     * @param evt
     * @throws Exception
     */
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                //TODO
            }
            if (event.state() == IdleState.WRITER_IDLE) {
                //TODO
            }
            if (event.state() == IdleState.ALL_IDLE) {
                System.out.println("进入读写空闲......");
                System.out.println("channel 关闭之前：users 的数量为："+ChannelFactory.channelGroup.size());
                Channel channel = ctx.channel();
                ChannelFactory.unbind(channel);
                channel.close();
                System.out.println("channel 关闭之后：users 的数量为："+ChannelFactory.channelGroup.size());
            }
        }
    }
}
