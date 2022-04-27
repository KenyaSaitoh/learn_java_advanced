package pro.kensait.java.generics2.cast;

public class GenericsMain0 {
    public static void main(String[] args) {
        Foo foo = new Baz();
        Bar bar = Bar.class.cast(foo);
        Baz baz = Baz.class.cast(foo);

    
    }
}

class Foo {}
class Bar extends Foo {}
class Baz extends Bar {}