package com.suixin.server.server.handler;

import com.suixin.common.core.entity.po.SingleMsg;
import com.suixin.common.redis.service.RedisService;
import com.suixin.server.util.ChannelFactory;
import com.suixin.server.util.WebSocketResult;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class ImMsgHandler extends SimpleChannelInboundHandler<SingleMsg> {

    @Autowired
    private RedisService redisService;

    //服务器读取消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SingleMsg msg) {
        System.out.println("ImMsgHandler");

        Integer receiverId = msg.getReceiverId();
        Integer senderId = msg.getSenderId();
        //有userId查询channel
        Channel receiverChannel = ChannelFactory.getChannel(receiverId.toString());
        if (receiverChannel != null) {
            //对方在线
            receiverChannel.writeAndFlush(WebSocketResult.trans(msg));
        } else {
            //对方不在线
            //存储到redis的List，sender:receiver
            String key = senderId + ":" + receiverId;
            redisService.lPush(key, msg);
        }
        //持久化到im_msg
    }
}
