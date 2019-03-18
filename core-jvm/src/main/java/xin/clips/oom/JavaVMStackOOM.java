package xin.clips.oom;

// -xss2m :栈空间设置2MB
// OutOfMemoryError: unable to create new native thread
public class JavaVMStackOOM {
    private  void dontStop(){
        while (true){
            //
        }
    }
    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread(); //循环创建、启动线程
    }
}
