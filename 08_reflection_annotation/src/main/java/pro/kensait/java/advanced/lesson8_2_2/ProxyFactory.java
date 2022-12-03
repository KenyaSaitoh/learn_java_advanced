package pro.kensait.java.advanced.lesson8_2_2;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static <T> T getProxy(Class<T> clazz) {
        Object target = null;
        try {
            target = clazz.getDeclaredConstructor().newInstance();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        Object proxy = Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                new DynamicProxy(target)); // 任意のオブジェクトのラッパーとなる
        return clazz.cast(proxy);
    }
}