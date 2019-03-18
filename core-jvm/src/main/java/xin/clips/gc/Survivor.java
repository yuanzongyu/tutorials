package xin.clips.gc;

/**
 * 如果在survivor空间中相同年龄所有对象大小的总和大于survivor空间的一半，年龄大于或者等于该年龄的对象就可以直接进入老年代，
 * 无需等到maxternuingThreshold要求的年龄
 */
public class Survivor {
    private static final int _1MB = 1024 * 1024; //

    /**
     * JVM参数：-XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] all1, all2, all3, all4;
        all1 = new byte[_1MB / 4];
        all2 = new byte[_1MB / 4];
        all3 = new byte[4 * _1MB];
        all4 = new byte[4 * _1MB];
        all4 = null;
        all4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        Survivor.testAllocation();
    }
}
