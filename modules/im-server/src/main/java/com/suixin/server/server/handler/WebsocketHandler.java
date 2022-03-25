package com.suixin.server.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.*;

public class WebsocketHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
        System.out.println("WebsocketHandler");
        if (msg instanceof CloseWebSocketFrame) {
            ctx.channel().close();
        }

//        判断是否时ping消息
        if (msg instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(msg.content().retain()));
        }

//        判断是否是二进制消息，如果是二进制消息，就抛出异常
        if (msg instanceof BinaryWebSocketFrame) {
            System.out.println("目前我们不支持二进制消息");
            throw new RuntimeException(this.getClass().getName() + ":不支持消息");
        }

        if (msg instanceof TextWebSocketFrame) {
            /*
            维持msg不被释放
            方法一 分配新的内存区
             */
//            TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame) msg;
//            ByteBuf bytebuf = ctx.alloc().buffer();
//            bytebuf.writeBytes(textWebSocketFrame.text().getBytes(StandardCharsets.UTF_8));
//            ctx.fireChannelRead(new TextWebSocketFrame(bytebuf));

            /*
            方法二 retain()方法
             */
            ctx.fireChannelRead((TextWebSocketFrame) msg.retain());

            /*
             方法三 String对象 保存
             */
        }
    }
}
