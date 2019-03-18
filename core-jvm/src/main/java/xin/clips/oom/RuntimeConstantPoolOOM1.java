package xin.clips.oom;

import sun.misc.Unsafe;

/**
 * StringBuffer 加了synchronized ，StringBuilder没有加
 */
public class RuntimeConstantPoolOOM1 {
    public static void main(String[] args) {
        String str1=new StringBuffer("袁").append("总与").toString();
        System.out.println(str1.intern() == str1);  //  true

        String str2= new StringBuilder("计算机").append("软件").toString();
        System.out.println(str2.intern() ==str2); //  false

    }
}
