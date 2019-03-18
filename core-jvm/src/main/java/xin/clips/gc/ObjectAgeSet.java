package xin.clips.gc;

/**
 * 对象年龄计数器，每次对象在Eden出生并经过一次minor gc后还活着，则被分配到survivor空间，年龄+1，
 * 对象在survivor每熬过一次minor gc后，年龄+1，当15（默认）的时候，分配到老年代。
 * 1、-XX:MaxTenuringThreshold设置
 *
 */
public class ObjectAgeSet {

    private static final int _1MB = 1024 * 1024; //

    /**
     * JVM参数：-XX:+UseSerialGC -XX:MaxTenuringThreshold=1 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] all1, all2, all3, all4;
        all1 = new byte[_1MB / 4]; //256KB
        all2 = new byte[4 * _1MB];
        all3 = new byte[4 * _1MB]; //触发一次minor gc，256KB可以放到survior空间，这个时候eden区域正好是8MB
        all3 = null;
        all3 = new byte[4 * _1MB];  //在加入4MB，触发第二次minorgc，256kb放到了老年代
    }

    public static void main(String[] args) {
        ObjectAgeSet.testAllocation();  //-XX:MaxTenuringThreshold=1 ，设置进行一次minor gc 后，进入老年代
        //新生代总共可用： eden + from =9210 KB
    }

}
/*
*
* [GC (Allocation Failure) [DefNew: 6398K->659K(9216K), 0.0047883 secs] 6398K->4755K(19456K), 0.0048341 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 4840K->0K(9216K), 0.0011292 secs] 8936K->4743K(19456K), 0.0011550 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
Heap
 def new generation   total 9216K, used 4178K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  eden space 8192K,  51% used [0x00000007bec00000, 0x00000007bf014930, 0x00000007bf400000)
  from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400180, 0x00000007bf500000)
  to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 tenured generation   total 10240K, used 4743K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
   the space 10240K,  46% used [0x00000007bf600000, 0x00000007bfaa1e58, 0x00000007bfaa2000, 0x00000007c0000000)
 Metaspace       used 3290K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 362K, capacity 388K, committed 512K, reserved 1048576K

*
*
*
*
* */
