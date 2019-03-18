package xin.clips.gc;

/**
 * GC 回收算法：
 * 1、引用技术，缺点：无法处理循环引用问题
 * 2、循环引用，GC实现了回收，
 * 3、GC回收算法： GCRoots 进行向下搜索，引用链，如果没有任何的引用链，则表示对象不可达，确定其为可回收对象
 * GCRoots 对象包含下面的几种：
 * 1、虚拟机栈
 * 2、方法区静态属性引用的对象
 * 3、方法区常量引用的对象
 * 4、本地方法栈中JNI(native方法）应用的对象
 *
 * Jvm 引用类型4种：
 * 1、强引用(strong reference)
 * 2、软引用(soft reference) ，在内存溢出之前，先进行回收，这次回收还是没有足够的内存，抛出内存溢出异常 SoftReference
 * 3、弱引用(weak reference)  ，第二次垃圾收集前，GC工作的时候，无论当前的内存是否够用，都会回收弱引用关联的对象 WeakReference
 * 4、虚引用(幽灵引用)(Phantom Reference) 垃圾回收收到系统通知
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB = objA;
        objA = null;
        objB = null;
        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}

/**
 * /Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/bin/java -XX:+PrintGC "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=62068:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/tools.jar:/Users/yuanzongyu/Documents/develop_trial/tutorials/tutorials/core-jvm/target/classes xin.clips.gc.ReferenceCountingGC
 * [GC (System.gc())  6770K->536K(125952K), 0.0008692 secs]
 * [Full GC (System.gc())  536K->404K(125952K), 0.0040561 secs]
 * <p>
 * Process finished with exit code 0
 **/