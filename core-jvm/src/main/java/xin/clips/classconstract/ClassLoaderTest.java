package xin.clips.classconstract;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 双亲委派:如果一个类加载器收到了类加载的请求，首先不会自己去尝试加载这个类，将请求委托给父类加载器去完成，
 * 每一个层次的加载器都是如此
 *
 * Thread context ClassLoader ,Thread.setContextClassLoader()方法设置
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);  //通过字节流定义类
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        Object obj = myLoader.loadClass("xin.clips.classconstract.ClassLoaderTest").
                newInstance();  //newInstance()实例化类
        System.out.println(obj.getClass());
        // obj是我们自定义类加载的， ClassLaoderTest是系统加载的
        System.out.println(obj instanceof xin.clips.classconstract.ClassLoaderTest); // false

    }
}
