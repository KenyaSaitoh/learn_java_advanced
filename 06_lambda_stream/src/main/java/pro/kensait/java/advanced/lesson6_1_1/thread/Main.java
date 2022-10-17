package pro.kensait.java.advanced.lesson6_1_1.thread;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("[ Thread ] processing...");
        });
        t.start();
        System.out.println("[ Main ] finish");
    }
}