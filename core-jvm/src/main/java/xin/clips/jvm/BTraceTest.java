package xin.clips.jvm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BTraceTest {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        BTraceTest test = new BTraceTest();
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            reader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(test.add(a, b));
        }
    }
}
//
///* BTrace Script Template */
//import com.sun.btrace.annotations.*;
//        import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class TracingScript {
//    @OnMethod(
//            clazz="xin.clips.jvm.BTraceTest",
//            method="add",
//            location = @Location(Kind.RETURN)
//    )
//    public  static  void func(@Self xin.clips.jvm.BTraceTest instance,int a,int b, @Return int result){
//        println("调用栈:");
//        jstack();
//        println(strcat("方法参数 A：",str(a)));
//        println(strcat("方法参数B：",str(b)));
//        println(strcat("结果：",str(result)));
//    }
//}