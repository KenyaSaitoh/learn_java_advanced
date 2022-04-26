package pro.kensait.java.generics2.type.case2;

public class GenericsMain2 {

    public static void main(String[] args) {
        Bar<String> bar = new Bar<String>();

        // Fool<T>はBar<T>のスーパータイプなので代入が可能
        Foo<String> foo = bar;

        foo.getProperty();
    }
}