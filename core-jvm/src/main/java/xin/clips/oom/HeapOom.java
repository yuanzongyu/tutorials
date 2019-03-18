package xin.clips.oom;

import java.util.ArrayList;
import java.util.List;

//  -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
public class HeapOom {
    static class Test{
        Long[] l = new Long[5000];
    }

    public static void main(String[] args) {
        List<Test> list = new ArrayList<>();
        while (true){
            list.add(new Test());
        }
    }
}

/**
 java.lang.OutOfMemoryError: Java heap space
 Dumping heap to java_pid35109.hprof ...
 Heap dump file created [3267435 bytes in 0.015 secs]
 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 at xin.clips.oom.HeapOom$FinalizeEscapeGC.<init>(HeapOom.java:8)
 at xin.clips.oom.HeapOom.main(HeapOom.java:15)

 Process finished with exit code 1
**/