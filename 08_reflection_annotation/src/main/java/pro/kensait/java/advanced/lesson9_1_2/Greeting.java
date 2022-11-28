package pro.kensait.java.advanced.lesson9_1_2;

import java.util.Date;

public class Greeting {
    public String sayYes() {
        return "Yes!";
    }
    private String sayNo() {
        return "No!";
    }
    public String sayHello(String name, int age) {
        return "Hello! 私は" + name + "、" + age + "歳です";
    }
    static Date now; 
    static {
        now = new Date();
        System.out.println(now);
    }
}
