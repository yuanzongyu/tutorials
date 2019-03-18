package xin.clips.gc;

/**
 * 1、优先在eden区构建，如果没有足够空间，虚拟机进行minor GC
 * 2、-XX:+PrintGCDetails 收集日志，
 * 3、minor GC ：新生代垃圾收集，非常频繁
 * Full GC ： 老年代GC， 年轻代和老年代都会执行，慢10倍
 * <p>
 * -Xms:：初始内存
 * -Xmx：最大内存
 * -Xmn：年轻代大小
 * -Xss：每个线程栈大小
 * -XX:SurvivorRatio=8 eden：Survivor=8：1
 */
public class EdenGC {
    private static final int _1MB = 1024 * 1024; //

    /**
     * JVM参数：-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] all1, all2, all3, all4;
        all1 = new byte[2 * _1MB]; //
        all2 = new byte[2 * _1MB];
        all3 = new byte[2 * _1MB];
        all4 = new byte[4 * _1MB]; //出现一次minor gc, eden+form区不够分配了。触发一次minor gc
    }

    public static void main(String[] args) {
        EdenGC.testAllocation();
        //新生代总共可用： eden + from =9210 KB
    }
}


/**

 [GC (Allocation Failure) [DefNew: 8026K->403K(9216K), 0.0081701 secs] 8026K->6547K(19456K), 0.0085622 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 Heap
 def new generation   total 9216K, used 4666K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 eden space 8192K,  52% used [0x00000007bec00000, 0x00000007bf029990, 0x00000007bf400000)
 from space 1024K,  39% used [0x00000007bf500000, 0x00000007bf564f30, 0x00000007bf600000)
 to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
 Metaspace       used 3292K, capacity 4496K, committed 4864K, reserved 1056768K
 class space    used 363K, capacity 388K, committed 512K, reserved 1048576K

 Process finished with exit code 0
*/