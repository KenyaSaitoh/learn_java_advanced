package pro.kensait.java.advanced.lesson8_1_3.inheritence;

public class Main {

    public static void main(String[] args) {
        MyContainerIF<Integer> container = new MyContainer<>(100);
        int num = container.getProperty();
        System.out.println(num);

        MyContainer<String> container2 = new MySubContainer<String>("Hello");
        String message = container2.getProperty();
        System.out.println(message);
    }
}