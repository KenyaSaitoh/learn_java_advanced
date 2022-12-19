package pro.kensait.java.advanced.lsn_8_1_2.generictype;

public class Main {
    public static void main(String[] args) {

        MyContainer<Integer> container1 = new MyContainer<>(100);
        int num = container1.getProperty();
        System.out.println(num);
        
        MyContainer<String> container2 = new MyContainer<>("Hello");
        String str = container2.getProperty();
        System.out.println(str);
    }
}