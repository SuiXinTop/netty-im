package com.suixin.server.server.handler;

import com.suixin.common.entity.po.GroupMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class GroupMsgHandler extends SimpleChannelInboundHandler<GroupMsg> {
    //服务器读取消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMsg msg) {
        System.out.println("GroupMsgHandler");
        //持久化到group_msg
        int groupId = msg.getGroupId();

//                    //获取群内成员idList
//                    List<Integer> idList = new ArrayList<>(10);
//                    //遍历发送
//                    idList.remove(groupMsg.getSenderId());
//                    idList.forEach(userId -> {
//                        Channel channel = ChannelFactory.getChannel(userId.toString());
//                        if (channel != null) {
//                            channel.writeAndFlush(groupMsg);
//                        }
//                    });
    }
}
