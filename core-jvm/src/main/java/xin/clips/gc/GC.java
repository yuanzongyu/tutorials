package xin.clips.gc;

/**
 * 垃圾收集算法：
 * 1、标记-清除算法，缺点：会产生碎片，大对象无法分配空间
 * 2、复制算法(新生代用的算法)：
 *           分配一块较大的Eden空间和2块较小的survivor空间，默认是8:1。
 *           每次eden和一块survivor分配到另一个survivor，然后清空eden和survivor空间，survivor由老年带做担保
 * 3、标记-整理算法（老年代）：
 *           让活动对象都向一端移动，然后直接清理端边界以为的内存
 * 4、分代-收集算法：
 *           年轻代使用复制算法收集垃圾，老年代使用"标记-清除"或"标记-整理"算法
 * 5、HotSpot 收集算法
 *    1、前置条件：
 *               先进行GC停顿，保证GCRoots可以 使用"一致性"快照
 *    2、HotSpot
 *               使用OOPMap 类加载后，存到起来（记录偏移量等信息），GC扫描根据OOPMap 得知信息
 *    3、安全点：
 *               "长时间执行"：指令复用，例如：方法调用，循环跳转等
 *               抢断式中断：GC发生，所有线程全部中断，如果不在安全点，恢复线程，让其"跑"到安全点上
 *               主动式中断：设置标志，各个线程轮询这个标志，如果标志为true就自己中断挂起。轮询标志和安全点是重合的
 *    4、安全区域：
 *              一段代码片段中，引用关系不会发生变化，在这个区域种任意地方开始GC都是安全的。
 *
 *
 * 并发和并行区别：
 * 1、并发：用户线程和垃圾收集器线程同时执行（CPU 交替执行）
 * 2、并行：多个垃圾收集器线程同时执行，用户线程等待状态
 *
 *
 * 吞吐量：  运行用户代码时间 /运行用户代码时间+垃圾回收时间，如虚拟机运行100分钟，垃圾回收1分钟。吞吐量99%
 * 垃圾回收器：
 * 1、Serial：
 *                  需要stop the world 后，单线程执行垃圾收集 （年轻代收集器）
 * 2、ParNew:
 *                  复制+并行收集，stop the world 后，多线程执行垃圾收集，与CMS 配合收集！(年轻带收集器)
 * 3、Parallel Scavenge（并行打扫）:
 *                  复制+并行收集（年轻带收集器）
 *                  目的：可用的吞吐量
 *                  -XX:MaxGCPauseMillis (最大垃圾收集停顿时间)
 *                  -XX:GCTimeRatio(吞吐量大小) 0-100整数，(垃圾收集时间/总时间)比率
 *                  -XX:+UseAdaptiveSizePolicy jvm根据系统运行情况自动条件
 *
 * 4、CMS（ concurrent mark sweep ）：
 *         CMS 默认和ParNew配合使用，也可以搭配Serial收集器（老年代收集器）。目的缩短时间
 *         基于"标记-清除"算法，
 *         步骤：
 *         1、cms init mark 初始标记 （stop the world）
 *         2、cms concurrent mark 并发标记
 *         3、cms remark 重新标记（stop the world），为了确保程序运行一段时间有新的垃圾需要收集
 *         4、cms concurrent sweep 并发清除
 *         缺点：
 *         1、CMS收集器CPU资源非常敏感，CMS默认启动的回收线程=（CPU数量+3）/4，
 *            对于4核以下的，还需要线程执行垃圾回收，增加负担
 *         2、CMS无法处理浮动垃圾（Floating Garbage），导致"concurrent mode failure"导致 FULL GC
 *                 浮动垃圾:在并发清除的时候，程序还在运行，会产生新的垃圾，等到下一次GC才能收集。
 *                 92%触发，如果CMS运行期间预留内存无法满足需要，会出现"concurrent mode failure"，临时启动
 *                 "serial old"收集器重新对老年代进行垃圾回收，停顿时间会长。
 *         3、碎片多，如果大对象，会触发FUll GC，可以设置进行碎片的清理或者进行几次后压缩
 *
 *
 * 5、Serial Old：
 *              老年代版本，单线程收集器，使用"标记-整理"算法。适合1.5以下版本，或者作为CMS收集器的后选方案
 *
 * 6、Parallel old收集器：
 *              多线程 + "标记-整理"算法
 *
 * 7、G1收集器：适用于多核硬件
 *           并行和并发
 *           分代收集
 *           空间整合（标记-整理）
 *
 * 8、64位和32位系统： 指针膨胀、数据类型对齐补白
 */
public class GC {
}
