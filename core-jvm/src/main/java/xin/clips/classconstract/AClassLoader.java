package xin.clips.classconstract;

/**
 * class  可以动态加载到内存中，周期包含
 *
 * 1、loading 加载,反射、流
 * 2、verify 验证，如检查魔数、主版本号等
 * 3、preparation 准备
 *       为static变量 分配内存，类变量初始化接口 public static int value =100 ,准备阶段value的值是0
 *       public static final int value=123;  准备阶段分配ConstantValue属性，设置值为123
 * 4、resolution 解析
 *       将常量池中的符号引用转换位直接引用，如constant_class_info，constant_fildes_info，constant_method_info等
 * 5、init 初始化
 *       new、getstatic、 putstatic、 invokestatic、 类没有进行初始化，必须先初始化
 *       java.lang.reflect 包的方法进行反射的时候，如果类没有初始化，则需先初始化
 *       初始化一个类，如果其父类没有进行过初始化，先父类初始化
 *       jvm启动时，需要指定一个执行的主类(含有main（）)的， jvm初始化这个主类
 *       动态语言支持，如果一个java.lang.invoke.MethodHandle实例最后的解析结果 REF_getStatic，REF_putStatic，REF_invokeStatic
 *       句柄对应的类没有初始化，则需要先初始化
 * 6、using 使用
 * 7、unloading 卸载
 * 2+3+4 为连接(linking)
 *
 *
 */
public class AClassLoader {
}
