package pro.kensait.java.advanced.lesson9_1_2;

import java.io.Serializable;

public record Person(String name, int age, String gender) implements Serializable {
    private static final long serialVersionUID = -6011243720394071084L;

    public Person {
        if (name == null) throw new IllegalArgumentException("name is null");
        if (age < 0) throw new IllegalArgumentException("age is under 0");
    }

    public void sayHello() {
        String message = "こんにちは！私は" + name + "、" + age + "歳です。";
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "[ name => " + name + ", age => " + age + "]";
    }
}