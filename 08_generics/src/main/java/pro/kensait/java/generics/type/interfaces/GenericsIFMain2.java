package pro.kensait.java.generics.type.interfaces;

public class GenericsIFMain2 {

    public static void main(String[] args) {
        Bar<String> bar = new Bar<String>();

        // Fool<T>はBar<T>のスーパータイプなので代入が可能
        Foo<String> foo = bar;

        foo.getProperty();
    }
}