package pro.kensait.java.lambda.functional.predicate;

class User {
    private final Integer id;
    private final Integer age;

    public User(Integer id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isAdult() {
        return 20 <= this.age;
    }
}