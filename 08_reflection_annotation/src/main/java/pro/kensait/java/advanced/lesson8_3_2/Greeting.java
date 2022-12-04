package pro.kensait.java.advanced.lesson8_3_2;

@MyInfo(1)
public class Greeting {
    @MyInfo(2)
    private String personName;

    public Greeting(String personName) {
        this.personName = personName;
    }

    @MyInfo(value = 3, comment = "This is Japanese.")
    public void sayHello(@MyParam("age") int age) {
        System.out.println("こんにちは！私は" + personName + "、" + age + "歳です。");
    }
}