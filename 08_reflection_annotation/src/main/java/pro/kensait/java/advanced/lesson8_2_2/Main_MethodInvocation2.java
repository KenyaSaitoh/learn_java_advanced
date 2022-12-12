package pro.kensait.java.advanced.lesson8_2_2;

import java.lang.reflect.Method;

public class Main_MethodInvocation2 {
    public static void main(String[] args) throws Exception {
        // Classインスタンスを取得する
        Class<?> clazz = Class.forName(
                "pro.kensait.java.advanced.lesson8_2_2.Greeting");

        // メソッド実行対象クラスのインスタンスを生成する
        Object target = clazz.getDeclaredConstructor().newInstance();
        
        // Methodインスタンスを取得する
        Method method = clazz.getDeclaredMethod("getNo");

        // privateメソッドをアクセス可能にする
        method.setAccessible(true);

        // メソッドを実行する
        Object result = method.invoke(target);

        // 戻り値を表示する
        System.out.println(result);
    }
}