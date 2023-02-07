package pro.kensait.java.advanced.lsn_8_1_2;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            Class<Greeting> clazz = Greeting.class;
        }
        {
            System.out.println("***** snippet_2 *****");
            Greeting greeting = new Greeting();
            Class<?> clazz = greeting.getClass();
        }
        {
            System.out.println("***** snippet_3 *****");
            Class<Greeting> clazz = Greeting.class;
            System.out.println(clazz.getCanonicalName());
            System.out.println(clazz.getSimpleName());
            System.out.println(clazz.getPackageName());
        }
        {
            System.out.println("***** snippet_4 *****");
            Integer val1 = 100;
            Object obj = val1;
            // Integer val2 = (Integer) obj;
            Integer val2 = Integer.class.cast(obj);
        }
    }
}