package pro.kensait.java.advanced.lsn_8_3_2.maxlength;

public class Main_MaxLength {
    public static void main(String[] args) {
        Greeting greeting = new Greeting("Foooooooooo");
        AnnotationProcessor.checkMaxLength(greeting);
        greeting.getHello(25);
    }
}