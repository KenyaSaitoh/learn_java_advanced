package pro.kensait.java.generics.case4;

public class Bar {
    public void execute(Hoge<? extends Number> hoge) {
        System.out.println("[ Foo#execute ]");
        System.out.println("hoge --->" + hoge.getObject());
    }
}