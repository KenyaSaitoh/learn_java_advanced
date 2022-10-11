package pro.kensait.java.lesson6_1_4.predicate;

public class User {
    private int id;
    private int age;

    public User(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdult() {
        return 20 <= age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", age=" + age + "]";
    }
}