package pro.kensait.java.advanced.generics.cast;

public class CastMain2 {
    public static void main(String[] args) throws Exception {
        new CastMain2().process();
    }

    private void process() {
        Object obj = new String("Foo");
        String str = narrow(obj, String.class);
        System.out.println("String ---> " + str);
    }

    private <T> T narrow(Object obj, Class<T> clazz) {
        return clazz.cast(obj);
    }
}