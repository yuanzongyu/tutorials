package xin.clips.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Buffer 实际上是一块内存空间，可以读，也可以写，内存块被包裹在Buffer里，并提供一些使用的API
 * 1、clear()：清理整个Buffer
 * 2、compact()：清理已经读取的数据 (limit - pos)
 *
 * 3、mark <= position <= limit <= capacity
 *   limit：现在可以写入的最大数据，写入模式 limit= capacity，
 *
 * 4、写入数据到Buffer的方式
 *    4.1、直接通过buffer.put()写，写完pos+1
 *    4.2、通过channel.getchannel()拿到channel，在写
 * 5、buffer.rewind()可以再次读数据(pos=0,mark=-1)
 * 6、buffer.clear()清空缓存，如果缓存有数据则会丢失 ，如果任然需要未阅读的数据，后面在读，
 *    可以使用compact()方法代替clear()方法
 * 7、buffer.compact()方法会将未读取的数据放到Buffer的头(使用Unsafe.copyMemory())。
 *    最后设置pos为最后未读元素的最后,不会清空未读数据
 * 8、mark()和reset()
 *    通过buffer.mark()方法标记给定的Buffer的位置(pos)，后面可以通过buffer.reset()方法将pos回到mark的pos
 *    伪代码：
 *     buffer.mark()
 *     //call   buffer.get()
 *     buffer.reset();  // 设置pos为mark
 * 9、equals()和compareTo()
 *    equals():
 *        同样的数据类型(byte,int etc) + 相同数量的字节数 +  所有剩余的字节数
 *    compareTo()：
 *        在两个buffer进行比较剩余的元素
 *        9.1、所有的元素相等，但是第一个缓存区的元素在第二个缓冲区之前耗尽了数据
 *        9.2、 与另一个缓冲区中的对应相等的第一个元素小于另一个缓冲区中的元素
 *
 */
public class BuffterClient {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf); //从Buffer中读
        while (bytesRead != -1) {
            buf.flip(); //将写模式变成读模式,pos被重置为0
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());  //buf.get()读取数据
            }
            buf.clear(); //清空Buffer，pos=0,limit=cap
            bytesRead = inChannel.read(buf);

        }
        aFile.close();
    }
}
