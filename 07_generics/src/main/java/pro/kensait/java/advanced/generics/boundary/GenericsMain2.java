package pro.kensait.java.advanced.generics.boundary;

public class GenericsMain2 {
    public static void main(String[] args) {
        PiyoApi piyo = new PiyoApi();

        // Stringが引数の場合は、CharSequenceなのかComparableなのか判断できないため、
        // メソッドの前に<>で明示的に指定が必要
        piyo.<CharSequence>process("100");

        // Integerの場合は明示的に指定は不要
        piyo.process(100);
        piyo.<Integer>process(100);
    }
}