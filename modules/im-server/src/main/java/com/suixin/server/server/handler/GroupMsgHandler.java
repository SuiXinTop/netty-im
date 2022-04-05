package com.suixin.server.server.handler;

import com.suixin.common.core.constant.CacheConstant;
import com.suixin.common.core.entity.po.GroupMsg;
import com.suixin.common.redis.service.RedisService;
import com.suixin.server.mapper.ImGroupMapper;
import com.suixin.server.mapper.GroupMsgMongo;
import com.suixin.server.util.ChannelFactory;
import com.suixin.server.util.WebSocketResult;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@ChannelHandler.Sharable
public class GroupMsgHandler extends SimpleChannelInboundHandler<GroupMsg> {

    @Autowired
    private RedisService redisService;

    @Autowired
    private GroupMsgMongo mongo;

    @Autowired
    private ImGroupMapper imGroupMapper;

    //服务器读取消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMsg msg) {
        System.out.println("GroupMsgHandler");

        //从redis获取在线群成员的idList
        Set<String> onlineUserIdSet = new HashSet<>();
        try {
            onlineUserIdSet = (Set<String>) redisService.get(CacheConstant.ONLINE_USER_PREFIX);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        if (!onlineUserIdSet.isEmpty()) {
            //从缓存中获取群成员
            int groupId = msg.getGroupId();
            Set<String> groupUserIdSet;
            String key = CacheConstant.GROUP_USER_PREFIX + groupId;
            if (redisService.hasKey(key)) {
                groupUserIdSet = (Set<String>) redisService.get(key);
            } else {
                groupUserIdSet = imGroupMapper.getUserIdSetByGroupId(groupId);
            }

            //求交集--在线群员
            onlineUserIdSet.retainAll(groupUserIdSet);
            onlineUserIdSet.remove(msg.getSenderId());

            onlineUserIdSet.forEach(userId -> {
                Channel channel = ChannelFactory.getChannel(userId.toString());
                if (channel != null) {
                    channel.writeAndFlush(WebSocketResult.trans(msg));
                }
            });
        }

        //持久化到group_msg
        mongo.save(msg);
    }

}
