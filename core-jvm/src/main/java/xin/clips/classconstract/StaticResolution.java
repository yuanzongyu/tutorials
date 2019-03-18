package xin.clips.classconstract;

public class StaticResolution {
    public static void sayHello(){
        System.out.println("hello world~ ");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }

}

//
//Classfile /Users/yuanzongyu/Documents/develop_trial/tutorials/tutorials/core-jvm/src/main/java/xin/clips/classconstract/StaticResolution.class
//Last modified Mar 18, 2019; size 531 bytes
//        MD5 checksum f0d655a40d506cb2a5845fdc5e580914
//        Compiled from "StaticResolution.java"
//public class xin.clips.classconstract.StaticResolution
//        minor version: 0
//        major version: 52
//        flags: ACC_PUBLIC, ACC_SUPER
//        Constant pool:
//        #1 = Methodref          #7.#17         // java/lang/Object."<init>":()V
//        #2 = Fieldref           #18.#19        // java/lang/System.out:Ljava/io/PrintStream;
//        #3 = String             #20            // hello world~
//        #4 = Methodref          #21.#22        // java/io/PrintStream.println:(Ljava/lang/String;)V
//        #5 = Methodref          #6.#23         // xin/clips/classconstract/StaticResolution.sayHello:()V
//        #6 = Class              #24            // xin/clips/classconstract/StaticResolution
//        #7 = Class              #25            // java/lang/Object
//        #8 = Utf8               <init>
//   #9 = Utf8               ()V
//           #10 = Utf8               Code
//           #11 = Utf8               LineNumberTable
//           #12 = Utf8               sayHello
//           #13 = Utf8               main
//           #14 = Utf8               ([Ljava/lang/String;)V
//           #15 = Utf8               SourceFile
//           #16 = Utf8               StaticResolution.java
//           #17 = NameAndType        #8:#9          // "<init>":()V
//           #18 = Class              #26            // java/lang/System
//           #19 = NameAndType        #27:#28        // out:Ljava/io/PrintStream;
//           #20 = Utf8               hello world~
//           #21 = Class              #29            // java/io/PrintStream
//           #22 = NameAndType        #30:#31        // println:(Ljava/lang/String;)V
//           #23 = NameAndType        #12:#9         // sayHello:()V
//           #24 = Utf8               xin/clips/classconstract/StaticResolution
//           #25 = Utf8               java/lang/Object
//           #26 = Utf8               java/lang/System
//           #27 = Utf8               out
//           #28 = Utf8               Ljava/io/PrintStream;
//           #29 = Utf8               java/io/PrintStream
//           #30 = Utf8               println
//           #31 = Utf8               (Ljava/lang/String;)V
//           {
//public xin.clips.classconstract.StaticResolution();
//        descriptor: ()V
//        flags: ACC_PUBLIC
//        Code:
//        stack=1, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//        LineNumberTable:
//        line 3: 0
//
//public static void sayHello();
//        descriptor: ()V
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=2, locals=0, args_size=0
//        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        3: ldc           #3                  // String hello world~
//        5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        8: return
//        LineNumberTable:
//        line 5: 0
//        line 6: 8
//
//public static void main(java.lang.String[]);
//        descriptor: ([Ljava/lang/String;)V
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=0, locals=1, args_size=1
//        0: invokestatic  #5                  // Method sayHello:()V
//        3: return
//        LineNumberTable:
//        line 9: 0
//        line 10: 3
//        }
//        SourceFile: "StaticResolution.java"
