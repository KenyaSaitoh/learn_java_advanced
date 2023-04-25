package pro.kensait.java.advanced.lsn_8_2_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main_MethodInvocation_1 {
    public static void main(String[] args) throws Exception {
        // 【1】Classインスタンスを取得する
        Class<?> clazz = Class.forName(
                "pro.kensait.java.advanced.lesson8_2_2.Greeting");

        // 【2】メソッド実行対象クラスのConstructorインスタンスを取得する
        Constructor<?> constructor = clazz.getDeclaredConstructor();

        // 【3】メソッド実行対象クラスのインスタンスを生成する
        Object target = constructor.newInstance();

        // 【4】Methodインスタンスを取得する
        Method method = clazz.getMethod("getYes");

        // 【5】メソッドを実行する
        Object result = method.invoke(target);

        // 戻り値を表示する
        System.out.println(result);
    }
}