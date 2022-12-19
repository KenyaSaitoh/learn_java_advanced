package pro.kensait.java.advanced.lsn_8_1_2;

import java.util.Date;

public class Main_ClassClass_1 {
    public static void main(String[] args) throws Exception {
        // Classインスタンスを取得する
        Class<?> clazz1 = Class.forName(
                "pro.kensait.java.advanced.lesson9_1_1.Greeting"); // この時点でスタティックイニシャライザー動く

        Date date = Greeting.now; // この時点でスタティックイニシャライザー動く

        Greeting greeting = new Greeting(); // この時点でスタティックイニシャライザー動く
        Thread.sleep(10000);
        Class<?> clazz3 = greeting.getClass();

        Class<Greeting> clazz4 = Greeting.class; // この時点でスタティックイニシャライザー動かない
        clazz4.getDeclaredConstructor().newInstance();
    }
}