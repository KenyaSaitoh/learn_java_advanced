package pro.kensait.java.generics.case2;

public class GenericsMain22 {
    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        Object obj = new String("Foo");
        String str = manager.narrow(obj, String.class);
        System.out.println("String ---> " + str);
    }
}