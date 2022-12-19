package pro.kensait.java.advanced.lsn_8_1_2;

public class Main_ClassClass_2 {
    public static void main(String[] args) throws Exception {
        Class<Greeting> clazz = Greeting.class;
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getPackageName());
    }
}