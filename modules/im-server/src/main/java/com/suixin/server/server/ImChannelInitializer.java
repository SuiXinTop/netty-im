package com.suixin.server.server;

import com.suixin.server.server.handler.*;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * channel初始化，channelHandler连接
 */
@Component
public class ImChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private ImMsgHandler imMsgHandler;

    @Autowired
    private GroupMsgHandler groupMsgHandler;

    @Value("${netty.websocket.path}")
    private String path;

    @Value("${netty.websocket.readerIdleTime}")
    private int readerIdleTime;

    @Value("${netty.websocket.writerIdleTime}")
    private int writerIdleTime;

    @Value("${netty.websocket.allIdleTime}")
    private int allIdleTime;

    protected void initChannel(SocketChannel sc) {
        ChannelPipeline pipeline = sc.pipeline();
        //处理http消息的编解码
        pipeline.addLast(new HttpServerCodec())
                /*
                 HttpObjectAggregator 因为http在传输过程中是分段的，HttpObjectAggregator可以将多个段聚合起来
                  这就是为什么当浏览器发送大量数据时，会发出多次http请求
                 */
                // HttpContent 压缩
                .addLast(new ChunkedWriteHandler())
                //httpContent消息聚合
                .addLast(new HttpObjectAggregator(1024 * 64))
                /*
                  针对客户端，如果在时间内没有向服务端发送读写心跳（ALL），则主动断开连接
                  如果有读空闲和写空闲，则不做任何处理
                 */
                .addLast(new IdleStateHandler(readerIdleTime, writerIdleTime, allIdleTime))
                //自定义的空闲状态检测的handler
                .addLast(HeartBeatHandler.getInstance())
                /*
                 WebSocketServerProtocolHandler 对应websocket，它的数据是以帧(frame)形式传递
                  可以看到 WebSocketFrame 下有六个子类
                  浏览器请求时，ws://localhost:7000/XXX 表示请求的资源
                  核心功能是 将http协议升级为ws协议，保持长连接
                 */
                .addLast(new WebSocketServerProtocolHandler(path))
                .addLast(WebsocketHandler.getInstance())
                .addLast(ImServerMsgHandler.getInstance())
                .addLast(BindMsgHandler.getInstance())
                .addLast(imMsgHandler)
                .addLast(groupMsgHandler)
                .addLast(ExceptionHandler.getInstance())
        ;
    }

}
