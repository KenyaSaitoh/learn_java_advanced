package pro.kensait.java.advanced.lesson9_1_2;

import java.lang.reflect.Method;

public class Main_MethodInvocation3 {
    public static void main(String[] args) throws Exception {
        // Classインスタンスを取得する
        Class<?> clazz = Class.forName(
                "pro.kensait.java.advanced.lesson9_1_2.Greeting");

        // メソッド実行対象クラスのインスタンスを生成する
        Object target = clazz.getDeclaredConstructor().newInstance();
        
        // Methodインスタンスを取得する
        Method method = clazz.getDeclaredMethod("sayHello", String.class, Integer.TYPE);

        // メソッドを実行する
        Object[] params = new Object[2];
        params[0] = "Alice";
        params[1] = 25;
        Object result = method.invoke(target, params);

        // 戻り値を表示する
        System.out.println(result);
    }
}