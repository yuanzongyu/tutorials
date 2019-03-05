package xin.clips.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Channel和Channel互传数据
 * 此例子使用两个FileChannel
 */
public class FileChannelTransferFrom {
    public static void main(String[] args) throws Exception{
        RandomAccessFile fromFile = new RandomAccessFile("a.txt","rw"); //不允许只写
        FileChannel from = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("b.txt","rw");
        FileChannel to = toFile.getChannel();
        long pos = 0;
        long count = from.size();

        to.transferFrom(from,pos,count); // from的内容写入到to
    }
}
