package pro.kensait.java.generics2.case4;

public class GenericsMain5 {

    public static void main(String[] args) {
        Bar<String> bar = new Bar<String>();

        // Foo<T>はBar<T>のスーパータイプなので代入が可能
        Foo<String> foo = bar;
    }
}