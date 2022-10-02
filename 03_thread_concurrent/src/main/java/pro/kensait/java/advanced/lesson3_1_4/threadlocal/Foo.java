package pro.kensait.java.advanced.lesson3_1_4.threadlocal;

public class Foo {
    public void process() {
        String value = ThreadLocalHolder.get().get("name");
        System.out.println("[ Foo#process ] name => " + value);
    }
}
