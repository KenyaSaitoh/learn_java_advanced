package pro.kensait.java.advanced.lesson6_1_4.consumer;

public class Main_Builder {
    public static void main(String[] args) {
        Person alice = Person.build(person -> {
            person.withName("Alice").withAge(25).withGender("female");
        });
        System.out.println(alice);
    }
}