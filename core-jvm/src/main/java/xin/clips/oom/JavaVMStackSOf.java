package xin.clips.oom;

// -Xss128k
// jdk1.8 jvm栈大小最低160k
// 每个线程的栈分配的内存越大，反而更容易避免StackOverFlowError（2GB - Xmx - MaxPermSize(最大方法区容量)，可以建立的线程更少了）
// 通过减少堆和方法区大小，满足多线使用，避免StackOverFlowError
public class JavaVMStackSOf {
    private int stackLength = 1;

    //栈泄露
    public void stackLeak() {
        stackLength++;
        stackLeak(); //循环调用
    }

    public static void main(String[] args) {
        JavaVMStackSOf oom = new JavaVMStackSOf();
        try {
            oom.stackLeak();
        } catch (Throwable a) {
            System.out.println("stack length: " + oom.stackLength); // stack length: 7776
            throw a; //StackOverflowError
        }

    }
}
