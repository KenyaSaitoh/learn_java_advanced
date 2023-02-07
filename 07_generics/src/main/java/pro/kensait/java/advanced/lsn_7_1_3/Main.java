package pro.kensait.java.advanced.lsn_7_1_3;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            MyContainerIF<Integer> container = new MyContainer<>(100);
            int num = container.getProperty();
            System.out.println(num);
        }
        {
            System.out.println("***** snippet_2 *****");
            MyContainer<String> container = new MySubContainer<String>("Hello");
            String message = container.getProperty();
            System.out.println(message);
        }
    }
}