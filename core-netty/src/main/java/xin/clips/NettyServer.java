package xin.clips;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class NettyServer {
    public static void main(String[] args) throws  Exception{
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();    //监听端口线程组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();  //处理每一条连接的数据读写的线程组

        //服务器启动引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boosGroup,workerGroup)
                .channel(NioServerSocketChannel.class) //指定IO模型
                .childHandler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
                        //连接读写处理逻辑
                    }
                });
        serverBootstrap.bind(8080).addListener(
                new GenericFutureListener<Future<? super Void>>() {
                    @Override
                    public void operationComplete(Future<? super Void> future) throws Exception {
                        if(future.isSuccess()){
                            System.out.println("端口绑定成功!");
                        }else{
                            System.out.println("端口绑定失败!");
                        }
                    }
                }
        ); //异步方法
        Thread.sleep(5000);
    }
    private static void bind(final ServerBootstrap serverBootstrap , final int port){
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("端口"+port+"绑定成功!");
                }else{
                    System.out.println("端口"+port+"绑定失败");
                    bind(serverBootstrap,port+1);
                }
            }
        });
    }
}
