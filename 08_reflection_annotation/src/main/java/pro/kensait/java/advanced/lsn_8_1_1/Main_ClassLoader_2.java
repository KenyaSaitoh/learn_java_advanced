package pro.kensait.java.advanced.lsn_8_1_1;

import java.net.http.HttpClient;

public class Main_ClassLoader_2 {
    public static void main(String[] args) throws Exception {
        ClassLoader cl1 = String.class.getClassLoader();
        System.out.println(cl1);
        ClassLoader cl2 = HttpClient.class.getClassLoader();
        System.out.println(cl2);
        ClassLoader cl3 = Greeting.class.getClassLoader();
        System.out.println(cl3);
    }
}