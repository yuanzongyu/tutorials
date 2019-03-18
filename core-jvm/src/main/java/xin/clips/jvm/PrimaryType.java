package xin.clips.jvm;

/**
 * new  对象后进行 基本数据类型初始化
 */
public class PrimaryType {
    private byte aByte;     //  0   取值范围： -128~127
    private short aShort;   //  0   取值范围： -32768~32767
    private int anInt;      //  0   2147483647
    private long aLong;     //  0
    private char aChar;     //  null  0-65535
    private float aFloat;   //  0.0
    private double aDouble; //  0.0
    private boolean aBoolean;  // false

    public static void main(String[] args) {

        PrimaryType p = new PrimaryType();  //类加载器介入
        System.out.println(p.aChar);
    }
}
