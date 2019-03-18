package xin.clips.classconstract;

public class FieldResolution {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        public static int A = 4;  //ambiguous：模糊不清的
        //  注释报错：Error:(21, 31) java: reference to A is ambiguous
        //  both variable A in xin.clips.classconstract.FieldResolution
        //  .Parent and variable A in xin.clips.classconstract.FieldResolution.Interface2 match
    }

    public static void main(String[] args) {
        System.out.println(Sub.A); // 输出4
    }
}
