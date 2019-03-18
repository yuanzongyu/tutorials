package xin.clips.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 *  -Xmx1M -XX:MaxDirectMemorySize=1M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws Exception{
        System.out.println("maxMemoryValue:"+sun.misc.VM.maxDirectMemory());


        System.out.println("================================");

        ByteBuffer buffer=ByteBuffer.allocateDirect(0);
        Class<?> c = Class.forName("java.nio.Bits");
        Field maxMemory = c.getDeclaredField("maxMemory");
        maxMemory.setAccessible(true);
        synchronized (c) {
            Long maxMemoryValue = (Long)maxMemory.get(null);
            System.out.println("maxMemoryValue:"+maxMemoryValue);
        }
    }
}
