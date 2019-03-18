package xin.clips.classconstract;

public class SynchronizedTest {

    void  onlyMe(Object f){
        synchronized (f){
            doSomething();
        }
    }
    public void doSomething(){
        System.out.println("dongsomething");
    }
}
//
// Classfile /Users/yuanzongyu/Documents/develop_trial/tutorials/tutorials/core-jvm/src/main/java/xin/clips/classconstract/SynchronizedTest.class
//Last modified Mar 15, 2019; size 651 bytes
//        MD5 checksum a66297e168d5f7493f0519024188ae86
//        Compiled from "SynchronizedTest.java"
//public class xin.clips.classconstract.SynchronizedTest
//        minor version: 0
//        major version: 52
//        flags: ACC_PUBLIC, ACC_SUPER
//        Constant pool:
//        #1 = Methodref          #7.#21         // java/lang/Object."<init>":()V
//        #2 = Methodref          #6.#22         // xin/clips/classconstract/SynchronizedTest.doSomething:()V
//        #3 = Fieldref           #23.#24        // java/lang/System.out:Ljava/io/PrintStream;
//        #4 = String             #25            // dongsomething
//        #5 = Methodref          #26.#27        // java/io/PrintStream.println:(Ljava/lang/String;)V
//        #6 = Class              #28            // xin/clips/classconstract/SynchronizedTest
//        #7 = Class              #29            // java/lang/Object
//        #8 = Utf8               <init>
//   #9 = Utf8               ()V
//           #10 = Utf8               Code
//           #11 = Utf8               LineNumberTable
//           #12 = Utf8               onlyMe
//           #13 = Utf8               (Ljava/lang/Object;)V
//           #14 = Utf8               StackMapTable
//           #15 = Class              #28            // xin/clips/classconstract/SynchronizedTest
//           #16 = Class              #29            // java/lang/Object
//           #17 = Class              #30            // java/lang/Throwable
//           #18 = Utf8               doSomething
//           #19 = Utf8               SourceFile
//           #20 = Utf8               SynchronizedTest.java
//           #21 = NameAndType        #8:#9          // "<init>":()V
//           #22 = NameAndType        #18:#9         // doSomething:()V
//           #23 = Class              #31            // java/lang/System
//           #24 = NameAndType        #32:#33        // out:Ljava/io/PrintStream;
//           #25 = Utf8               dongsomething
//           #26 = Class              #34            // java/io/PrintStream
//           #27 = NameAndType        #35:#36        // println:(Ljava/lang/String;)V
//           #28 = Utf8               xin/clips/classconstract/SynchronizedTest
//           #29 = Utf8               java/lang/Object
//           #30 = Utf8               java/lang/Throwable
//           #31 = Utf8               java/lang/System
//           #32 = Utf8               out
//           #33 = Utf8               Ljava/io/PrintStream;
//           #34 = Utf8               java/io/PrintStream
//           #35 = Utf8               println
//           #36 = Utf8               (Ljava/lang/String;)V
//           {
//public xin.clips.classconstract.SynchronizedTest();
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
//        void onlyMe(java.lang.Object);
//        descriptor: (Ljava/lang/Object;)V
//        flags:
//        Code:
//        stack=2, locals=4, args_size=2
//        0: aload_1
//        1: dup
//        2: astore_2
//        3: monitorenter
//        4: aload_0
//        5: invokevirtual #2                  // Method doSomething:()V
//        8: aload_2
//        9: monitorexit
//        10: goto          18
//        13: astore_3
//        14: aload_2
//        15: monitorexit
//        16: aload_3
//        17: athrow
//        18: return
//        Exception table:
//        from    to  target type
//        4    10    13   any
//        13    16    13   any
//        LineNumberTable:
//        line 6: 0
//        line 7: 4
//        line 8: 8
//        line 9: 18
//        StackMapTable: number_of_entries = 2
//        frame_type = 255  //full_frame
//        offset_delta = 13
//        locals = [ class xin/clips/classconstract/SynchronizedTest, class java/lang/Object, class java/lang/Object ]
//        stack = [ class java/lang/Throwable ]
//        frame_type = 250  //chop
//        offset_delta = 4
//
//public void doSomething();
//        descriptor: ()V
//        flags: ACC_PUBLIC
//        Code:
//        stack=2, locals=1, args_size=1
//        0: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        3: ldc           #4                  // String dongsomething
//        5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        8: return
//        LineNumberTable:
//        line 11: 0
//        line 12: 8
//        }
//        SourceFile: "SynchronizedTest.java"