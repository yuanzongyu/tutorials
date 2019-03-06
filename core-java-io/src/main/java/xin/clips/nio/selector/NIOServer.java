package xin.clips.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public void initServer(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open(); //通过静态open()方法打开ServerSocketChannel
        serverSocketChannel.configureBlocking(false); //设置为非阻塞模式
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost", port)); //服务器监听
        this.selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        System.out.println("服务器启动成功! ");
        while (true) {  //select 会出现空循环，浪费CPU资源
            selector.select(); // 进行阻塞blocking
            Iterator<SelectionKey> its = selector.selectedKeys().iterator();
            while (its.hasNext()) {
                SelectionKey key = its.next();
                if (key.isAcceptable()) {
                    SocketChannel channel = serverSocketChannel.accept(); //打开通道
                    channel.configureBlocking(false);//设置非阻塞模式
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    //准备读取
                    recvAndReply(key);
                }
                its.remove(); //移除
            }
        }
    }

    public void recvAndReply(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        int i = channel.read(buffer);
        if (i != -1) {
            //能获取到数据
            String msg = new String(buffer.array()).trim();
            System.out.println("nio 服务器收到信息:" + msg);
            System.out.println("nio 服务器返回:" + msg);
            channel.write(ByteBuffer.wrap(msg.getBytes())); //返回数据
        } else {
            //没有数据
            channel.close();
        }
    }

    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.initServer(9999);
        server.listen();
    }
}
