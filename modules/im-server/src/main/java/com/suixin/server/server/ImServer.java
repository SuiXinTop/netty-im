package com.suixin.server.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ImServer {
    private int port = 8080;

    public ImServer() {
    }

    public ImServer(int port) {
        this.port = port;
    }

    private static class SingleImServer {
        static final ImServer instance = new ImServer();
    }

    public static ImServer getInstance() {
        return SingleImServer.instance;
    }

    public void boot() {
        //构造两个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //服务端启动辅助类
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ImChannelInitializer());
            System.out.println("启动在" + port);
            ChannelFuture future = bootstrap.bind(port).sync();
            //等待服务端口关闭
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        getInstance().boot();
    }
}
