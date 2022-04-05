package com.suixin.server.server.handler;

import com.suixin.common.core.entity.po.GroupMsg;
import com.suixin.server.util.ChannelFactory;
import com.suixin.server.util.WebSocketResult;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ChannelHandler.Sharable
public class GroupMsgHandler extends SimpleChannelInboundHandler<GroupMsg> {

    //服务器读取消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMsg msg) {
        System.out.println("GroupMsgHandler");
        //持久化到group_msg
        int groupId = msg.getGroupId();
        //获取群内成员idList
        List<Integer> idList = new ArrayList<>(10);
        //遍历发送
        idList.remove(msg.getSenderId());
        idList.forEach(userId -> {
            Channel channel = ChannelFactory.getChannel(userId.toString());
            if (channel != null) {
                channel.writeAndFlush(WebSocketResult.trans(msg));
            }
        });
    }
}
