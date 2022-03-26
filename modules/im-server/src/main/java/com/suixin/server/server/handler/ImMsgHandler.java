package com.suixin.server.server.handler;

import com.suixin.common.entity.po.ImMsg;
import com.suixin.server.util.ChannelFactory;
import com.suixin.server.util.WebSocketResult;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class ImMsgHandler extends SimpleChannelInboundHandler<ImMsg> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //服务器读取消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ImMsg msg) {
        System.out.println("ImMsgHandler");
        Integer receiverId = msg.getReceiverId();
        Integer senderId = msg.getSenderId();
        //有userId查询channel
        Channel receiverChannel = ChannelFactory.getChannel(receiverId.toString());
        if (receiverChannel != null) {
            //对方在线
            System.out.println(msg);
            receiverChannel.writeAndFlush(WebSocketResult.trans(msg));
        } else {
            //对方不在线
            //存储到redis的List，sender:receiver
            String key = senderId + ":" + receiverId;
            redisTemplate.opsForList().leftPush(key, msg);
        }
        //持久化到im_msg
    }
}
