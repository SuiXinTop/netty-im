package com.suixin.server.util;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

import java.util.concurrent.ConcurrentHashMap;


public class ChannelFactory {

    static AttributeKey<String> USER = AttributeKey.newInstance("user");

    //用户ID与 channel对象的联系
    public static ConcurrentHashMap<String, Channel> channelGroup = new ConcurrentHashMap<>();

    /**
     * 绑定用户ID和channel对象，添加channel的attr
     *
     * @param userId
     * @param channel
     * @return
     */
    public static void bind(String userId, Channel channel) {
        if (channelGroup.containsKey(userId)) {
            //TODO
        }
        channel.attr(USER).set(userId);
        channelGroup.put(userId, channel);

    }

    /**
     * 移除在线channel
     *
     * @param channel
     * @return
     */
    public static void unbind(Channel channel) {
        String userId = channel.attr(USER).get();
        channelGroup.remove(userId);
    }

    /**
     * 获取channel对象
     *
     * @param id
     * @return
     */
    public static Channel getChannel(String userId) {
        return channelGroup.get(userId);
    }

    /**
     * 获取channel的attr
     * @param channel
     * @return
     */
    public static String getChannelAttr(Channel channel) {
        return channel.attr(USER).get();
    }

}
