package xin.clips.gc;


/**
 * 1、System.gc() 调用的是 Runtime.getRuntime().gc();
 * 2、System.gc() 建议垃圾回收器回收，调用对象的finalize()方法
 * 3、回收对象至少需要2次标记，第一次标记看是否不可达， 然后看finalize()是否有必要调用（没有必要调用：未覆盖finalize（）方法 or finalized()方法被虚拟机执行过）
 * 4、需要需要执行finalize()方法，会将对象放到一个F-Queue队列中，低优先级的finalizer线程去执行它，会去执行，但是不保证能执行结束。
 * 5、finalize()可以自救一次，
 */
public class FinalizeEscapeGC {
    long[] t = new long[5000];
    private static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("是的，我还活着! ");
    }

    @Override
    protected void finalize() throws Throwable {    //可以在此将对象重生,如何重生：增加引用链，GCroots 可达即可
        super.finalize();
        System.out.println("finalize 方法执行成功！");
        FinalizeEscapeGC.SAVE_HOOK = this;  // 自救
        System.out.println("gc 执行清理!");
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;       //对象第一次成功拯救自己
        Thread.sleep(500); //因为finalize方法优先级很低，所以暂定0.5秒等待它
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("不，我已经死了! ");
        }
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("不，我已经死了! ");
        }
    }
}
