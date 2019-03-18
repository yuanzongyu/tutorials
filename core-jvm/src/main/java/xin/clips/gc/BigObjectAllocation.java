package xin.clips.gc;

/**
 * 大对象直接分配到老年代
 *
 *  -XX:PretenureSizeThreadshold 参数，大于这个设置的值直接在老年代分配，减少eden以及form to 的来回内存复制
 *  只是用于年轻代的serial 和ParNew 模式，不支持parallel scavenge模式
 */
public class BigObjectAllocation {

    private static final int _1MB = 1024 * 1024; //

    /**
     * JVM参数：-XX:+UseSerialGC -XX:PretenureSizeThreshold=414728 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] all1, all2, all3, all4;
        //all1 = new byte[2 * _1MB]; //
        //all2 = new byte[2 * _1MB];
        //all3 = new byte[2 * _1MB];
        all4 = new byte[4 * _1MB]; //出现一次minor gc, eden+form区不够分配了。触发一次minor gc
    }

    public static void main(String[] args) {
        BigObjectAllocation.testAllocation();  //超过PretenureSizeThreshold设置的大小，直接分配到老年代
        //新生代总共可用： eden + from =9210 KB
    }
}
/**
 *
 * Heap
 *  def new generation   total 9216K, used 2210K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   eden space 8192K,  26% used [0x00000007bec00000, 0x00000007bee28b80, 0x00000007bf400000)
 *   from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 *  tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *    the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00010, 0x00000007bfa00200, 0x00000007c0000000)
 *  Metaspace       used 3286K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 361K, capacity 388K, committed 512K, reserved 1048576K
 **/