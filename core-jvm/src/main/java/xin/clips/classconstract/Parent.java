package xin.clips.classconstract;

public class Parent {
    public static int A = 1;

    static {  //  多线程会阻塞  ,同一个类加载器，只会执行一次
        A = 2;
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);  //2
    }
}
