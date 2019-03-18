package xin.clips.gc;

/**
 * 永久代：回收废弃常量和无用的类
 * 无用的类：
 * 1、该类的Classloader已经被回收
 * 2、该类的所有的实例被回收，堆中不存在任何的实例
 * 3、该类对应的java.lang.Class对象没有任何地方被引用，无法通过反射访问该类的方法
 */
public class Gem {
}
