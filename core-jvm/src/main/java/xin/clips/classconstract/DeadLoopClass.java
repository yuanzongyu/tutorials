package xin.clips.classconstract;

public class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "run over");
            }
        };
        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);
        t1.start();
        t2.start();
        //一个线程调用static，另一个线程阻塞等待，  static 类加载器运行一次
    }
}
