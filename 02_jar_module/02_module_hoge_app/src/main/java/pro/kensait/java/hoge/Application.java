package pro.kensait.java.hoge;

// import pro.kensait.java.foo.internal.Common;
import pro.kensait.java.foo.library.StringLibrary;

public class Application {

    public static void main(String[] args) {
        int result = new StringLibrary().getStrLengthSum("ABCDE", "ABCDEFGH");
        System.out.println(result);

        // int result2 = new Common().add(10, 20);
        // System.out.println(result2);
    }
}