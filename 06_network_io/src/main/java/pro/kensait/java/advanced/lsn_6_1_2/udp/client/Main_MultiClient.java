package pro.kensait.java.advanced.lsn_6_1_2.udp.client;

public class Main_MultiClient {
    public static void main(String[] args) {
        new Thread(new ClientTask("Alice")).start();
        new Thread(new ClientTask("Bob")).start();
        new Thread(new ClientTask("Carol")).start();
    }
}