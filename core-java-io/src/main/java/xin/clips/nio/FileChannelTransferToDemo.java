package xin.clips.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelTransferToDemo {
    public static void main(String[] args) throws Exception{
        RandomAccessFile from = new RandomAccessFile("a.txt","rw");
        FileChannel fromChannel = from.getChannel();
        RandomAccessFile to = new RandomAccessFile("b.txt","rw");
        FileChannel  toChannel = to.getChannel();
        long pos = 0 ;
        long count = fromChannel.size();
        fromChannel.transferTo(pos,count,toChannel); //将Form内容写入到toChannel中
    }
}
