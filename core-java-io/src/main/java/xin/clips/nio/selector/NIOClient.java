package xin.clips.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    SocketChannel channel;

    public void initClient(String host,int port) throws IOException{
        InetSocketAddress servAdds = new InetSocketAddress(host,port);  //地址
        this.channel = SocketChannel.open(servAdds);   //SocketChannel.open() 通过InetSocketAddress打开一个通道
    }

    public void sendAndRecv(String words) throws  IOException{
        byte[] msg = new String(words).getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(msg);
        System.out.println("client 发送数据:"+words);
        channel.write(buffer); //通过buffer写数据到channel
        buffer.clear();
        channel.read(buffer); //读数据
        System.out.println("client 接收到数据："+new String(buffer.array()).trim());
        channel.close(); //channel用完关闭
    }

    public static void main(String[] args) throws IOException{
        NIOClient client = new NIOClient();
        client.initClient("localhost",9999);
        client.sendAndRecv("showm me the money");
    }


}
