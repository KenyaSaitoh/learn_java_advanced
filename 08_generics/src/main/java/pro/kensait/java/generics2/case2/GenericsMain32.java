package pro.kensait.java.generics2.case2;

public class GenericsMain32 {
    public static void main(String[] args) {
        Foo bar = new Foo("Bar");
        bar.setTarget("BarBar");
        String str = (String)bar.getTarget();
        System.out.println(str);
    }
}