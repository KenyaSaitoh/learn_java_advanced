package pro.kensait.java.advanced.lesson9_1_2;

public class Main_ClassClass {
    public static void main(String[] args) throws Exception {
        // Classインスタンスを取得する
        //Class<?> clazz = Class.forName(
        //        "pro.kensait.java.advanced.lesson9_1_2.Greeting"); // この時点でスタティックイニシャライザー動く

        //Class<?> clazz = Class.forName(Greeting.class.getName()); // この時点でスタティックイニシャライザー動く

        /*
        Greeting greeting = new Greeting(); // この時点でスタティックイニシャライザー動く
        Thread.sleep(10000);
        Class<?> clazz = greeting.getClass();
        */

        Class<?> clazz = Greeting.class; // この時点でスタティックイニシャライザー動かない
        clazz.getDeclaredConstructor().newInstance();
    }
}