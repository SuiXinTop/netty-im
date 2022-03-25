package com.suixin.server.server.handler;

import com.alibaba.fastjson.JSON;
import com.suixin.common.entity.dto.BindMsg;
import com.suixin.common.entity.dto.TransMsg;
import com.suixin.common.entity.po.GroupMsg;
import com.suixin.common.entity.po.ImMsg;
import com.suixin.server.util.ChannelFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class ImServerMsgHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("客户端与服务端连接开启....");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        System.out.println("客户端与服务端连接关闭....");
    }

    //客户端与服务端创建连接
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("客户端与服务端连接开启....");
    }

    //客户端与服务端断开连接
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        ChannelFactory.unbind(ctx.channel());
        System.out.println("客户端与服务端连接关闭....");
    }

    //服务器读取消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        System.out.println("IMServerHandler");
        TransMsg transMsg = JSON.parseObject(msg.retain().text(), TransMsg.class);
        System.out.println(transMsg);
        int action = transMsg.getAction();
        /*
        初始化连接或重连
        初始化channel，关联 channel 和 userid
         */
        if (action == 0) {
            BindMsg bindMsg = JSON.parseObject(msg.text(), BindMsg.class);
            System.out.println(bindMsg);
            ctx.fireChannelRead(bindMsg);
        }
        /*
        聊天消息处理
         */
        if (action == 1) {
            //群聊或私聊
            switch (transMsg.getChatType()) {
                case 0://私聊
                    ImMsg imMsg = JSON.parseObject(msg.text(), ImMsg.class);
                    System.out.println(imMsg);
                    ctx.fireChannelRead(imMsg);

                    break;
                case 1://群聊
                    GroupMsg groupMsg = JSON.parseObject(msg.text(), GroupMsg.class);
                    ctx.fireChannelRead(groupMsg);
                    break;
                default:
                    break;
            }
        }

        /*
        消息签收处理
         */
        if (action == 2) {
            //TODO
        }

        /*
        心跳包处理
         */
        if (action == 3) {

        }

    }

}
