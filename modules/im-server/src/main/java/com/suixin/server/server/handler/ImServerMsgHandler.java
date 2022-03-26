package com.suixin.server.server.handler;

import com.alibaba.fastjson.JSON;
import com.suixin.common.entity.dto.BindMsg;
import com.suixin.common.entity.dto.TransMsg;
import com.suixin.common.entity.po.GroupMsg;
import com.suixin.common.entity.po.ImMsg;
import com.suixin.server.util.WebSocketResult;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

@ChannelHandler.Sharable
public class ImServerMsgHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final ImServerMsgHandler INSTANCE = new ImServerMsgHandler();

    public static ImServerMsgHandler getInstance() {
        return INSTANCE;
    }

    //服务器读取消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        System.out.println("IMServerHandler");
        TransMsg transMsg = null;
        try {
            transMsg = JSON.parseObject(msg.retain().text(), TransMsg.class);
        } catch (Exception e) {
            transMsg = new TransMsg(9, 9, "暂不支持该消息");
        }
        System.out.println(transMsg);
        int action = transMsg.getAction();
        /*
        初始化连接或重连
        初始化channel，关联 channel 和 userid
         */
        if (action == 1) {
            BindMsg bindMsg = JSON.parseObject(msg.text(), BindMsg.class);
            System.out.println(bindMsg);
            ctx.fireChannelRead(bindMsg);
        }
        /*
        聊天消息处理
         */
        else if (action == 2) {
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
        心跳包处理
         */
        else if (action == 3) {

        } else {
            ctx.writeAndFlush(WebSocketResult.trans(transMsg));
        }

    }

}
