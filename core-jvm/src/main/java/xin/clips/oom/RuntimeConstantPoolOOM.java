package xin.clips.oom;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 方法区：存放Class信息，代码、方法、运行时常量池，JIT代码等
 *
 * s.intern()：native 方法，如果常量池中有，则返回常量池的字符串，否则将其放到常量池，返回String的引用
 * -XX:PermSize=1M -XX:MaxPermSize=1M
 * jdk1.8：PermSize和MaxPermSize 被ignoring 了
 *
 *
 *
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
         //使用List保持常量池的引用，避免Full GC 回收常量池行为
        List<String> list = new ArrayList<>();
        int i=0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
