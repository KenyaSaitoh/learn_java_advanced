package pro.kensait.java.lesson6_1_4.consumer;

import java.util.function.Consumer;

public class Person {
    // フィールド
    private String name;
    private int age;
    private String gender;
    // コンストラクタ
    private Person() {}
    // ゲッター
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    // フィールド値の設定用メソッド
    public Person name(String name) {
        this.name = name;
        return this;
    }
    public Person age(int age) {
        this.age = age;
        return this;
    }
    public Person gender(String gender) {
        this.gender = gender;
        return this;
    }
    // ビルダーメソッド
    public static Person build(Consumer<Person> builder) {
        Person person = new Person();
        builder.accept(person);
        return person;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
}