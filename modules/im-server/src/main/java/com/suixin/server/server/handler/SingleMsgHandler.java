package com.suixin.server.server.handler;

import com.suixin.common.core.constant.CacheConstant;
import com.suixin.common.core.entity.po.SingleMsg;
import com.suixin.common.redis.service.RedisService;
import com.suixin.server.mapper.SingleMsgMongo;
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
public class SingleMsgHandler extends SimpleChannelInboundHandler<SingleMsg> {

    @Autowired
    private RedisService redisService;

    @Autowired
    private SingleMsgMongo mongo;

    //服务器读取消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SingleMsg msg) {
        System.out.println("ImMsgHandler");

        String receiverId = msg.getReceiverId();
        String senderId = msg.getSenderId();
        //由userId查询channel
        Channel receiverChannel = ChannelFactory.getChannel(receiverId);
        if (receiverChannel != null) {
            //对方在线
            receiverChannel.writeAndFlush(WebSocketResult.trans(msg));
        } else {
            //对方不在线
            //存储到redis的List，offline:msg:senderId:receiverId List<SingleMsg>
            String key = CacheConstant.OFFLINE_SINGLE_MSG_PREFIX + senderId + ":" + receiverId;
            redisService.lPush(key, msg);
        }

        //持久化到single_msg
        mongo.save(msg);
    }

}
