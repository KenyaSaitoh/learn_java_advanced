package pro.kensait.java.lesson6_1_4.consumer;

public class Main_Builder {
    public static void main(String[] args) {
        Person alice = Person.build(person -> {
            person.name("Alice").age(25).gender("female");
        });
        System.out.println(alice);
    }
}