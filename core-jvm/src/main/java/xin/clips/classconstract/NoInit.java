package xin.clips.classconstract;


/**
 * 被动引用示例
 */
class SuperClass {
    static {
        System.out.println("SuperClass init !");
    }

    public static int value = 123;  //getstatic 的时候触发
}

// 解析不一定在初始化之前
class SubClass extends SuperClass {
    static {
        System.out.println("subclass init!");// 不会输出
    }
}

public class NoInit {
    /**
     * 命令： -XX:+TraceClassLoading
     *
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(SubClass.value); // SuperClass init ! 打印 123
        SuperClass[] sca = new SuperClass[10];  //加载了。但是并没有被初始化！
    }
}