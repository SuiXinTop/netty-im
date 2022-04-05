package com.suixin.server.server.handler;

import com.alibaba.fastjson.JSON;
import com.suixin.common.core.enmu.MsgAction;
import com.suixin.common.core.entity.bo.BindTransMsg;
import com.suixin.common.core.entity.dto.TransMsg;
import com.suixin.common.core.entity.po.GroupMsg;
import com.suixin.common.core.entity.po.SingleMsg;
import com.suixin.server.util.WebSocketResult;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

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
        TransMsg transMsg;
        try {
            transMsg = JSON.parseObject(msg.retain().text(), TransMsg.class);
        } catch (Exception e) {
            transMsg = new TransMsg(MsgAction.ERROR, 9, "暂不支持该消息");
        }

        MsgAction action = transMsg.getAction();
        /*
        初始化连接或重连
        初始化channel，关联 channel 和 userid
         */
        if (action.getType() == 1) {
            BindTransMsg bindTransMsg = JSON.parseObject(msg.text(), BindTransMsg.class);
            System.out.println(bindTransMsg);
            ctx.fireChannelRead(bindTransMsg);
        }
        /*
        聊天消息处理
         */
        else if (action.getType() == 2) {
            //群聊或私聊
            switch (transMsg.getChatType()) {
                case 0://私聊
                    SingleMsg singleMsg = JSON.parseObject(msg.text(), SingleMsg.class);
                    System.out.println(singleMsg);
                    ctx.fireChannelRead(singleMsg);

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
        else if (action.getType() == 3) {
            //TODO
        }

        else {
            ctx.writeAndFlush(WebSocketResult.trans(transMsg));
        }

    }

}
