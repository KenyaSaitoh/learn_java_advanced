package pro.kensait.java.advanced.lesson8_2_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main_MethodInvocation1 {
    public static void main(String[] args) throws Exception {
        // Classインスタンスを取得する
        Class<?> clazz = Class.forName(
                "pro.kensait.java.advanced.lesson8_2_1.Greeting");

        // メソッド実行対象クラスのConstructorインスタンスを取得する
        Constructor<?> constructor = clazz.getDeclaredConstructor();

        // メソッド実行対象クラスのインスタンスを生成する
        Object target = constructor.newInstance();

        // Methodインスタンスを取得する
        Method method = clazz.getMethod("sayYes");

        // メソッドを実行する
        Object result = method.invoke(target);

        // 戻り値を表示する
        System.out.println(result);
    }
}