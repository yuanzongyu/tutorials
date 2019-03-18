package xin.clips.nio;

import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel_Map {
    public static void main(String[] args) {

        int BUFFER_SIZE = 1024;
        String fileName = "test.db";
        long fileLength = new File(fileName).length();
        int bufferCount = 1 + (int) (fileLength / BUFFER_SIZE);
        MappedByteBuffer[] buffers = new MappedByteBuffer[bufferCount];
        long remaining = fileLength;
        for (int i = 0; i < bufferCount; i++) {
            RandomAccessFile file;
            try {
                file = new RandomAccessFile(fileName, "r");
                buffers[i] = file.getChannel().map(FileChannel.MapMode.READ_ONLY,
                        i * BUFFER_SIZE, (int) Math.min(remaining, BUFFER_SIZE));
            } catch (Exception e) {
                e.printStackTrace();
            }
            remaining -= BUFFER_SIZE;
        }
    }
}
