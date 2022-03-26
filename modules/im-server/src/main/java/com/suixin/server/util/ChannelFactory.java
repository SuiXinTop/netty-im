package com.suixin.server.util;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;

import java.util.concurrent.ConcurrentHashMap;


public class ChannelFactory {

    static AttributeKey<String> USERID = AttributeKey.newInstance("userId");

    //用户ID与 channel对象的联系
    public static ConcurrentHashMap<String, Channel> channelGroup = new ConcurrentHashMap<>();

    /**
     * 绑定用户ID和channel对象，添加channel的attr
     */
    public static void bind(String userId, Channel channel) {
        if (channelGroup.containsKey(userId)) {
            //TODO 重复登陆
            Channel other = channelGroup.get(userId);
            other.writeAndFlush(new TextWebSocketFrame("异地登陆，强制下线"));
            channelGroup.remove(userId);
        }
        channel.attr(USERID).set(userId);
        channelGroup.put(userId, channel);
    }

    /**
     * 移除在线channel
     *
     * @param channel
     * @return
     */
    public static void unbind(Channel channel) {
        String userId = channel.attr(USERID).get();
        channelGroup.remove(userId);
    }

    /**
     * 获取channel对象
     *
     */
    public static Channel getChannel(String userId) {
        return channelGroup.get(userId);
    }

    /**
     * 获取channel的attr
     *
     */
    public static String getChannelAttr(Channel channel) {
        return channel.attr(USERID).get();
    }

}
